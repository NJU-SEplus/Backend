function affCharts(data) {
    //图在这里画，visual.js会自动调用
    //每个图各自包含在一个class为“chart-container”的div中
    var str = "<div class=\"chartsContainer\"><ul><li id='charts1'></li><li id='charts2'></li></ul></div>";
    $('body').append(str);
    drawWordCloud(data);
    drawBarChart(data);
}

function authorCharts(aId) {
    getRequest(
        "/Portrait/Author/id/" + aId,
        function (res) {
            drawAutherChart(res);
            drawAutherRelationCharts(res);
        }
    )
}

function test1() {
    var ul = "/Portrait/Author/id/20";

    $.get(ul, function (data) {
            if (!data.content) {
                notFound();
                return;
            }
            drawAutherChart(data);
            drawAutherYearCharts(data);
        }
    );

    var ul = "/Portrait/Author/Partners/20";
    $.get(ul, function (data) {
            if (!data.content) {
                notFound();
                return;
            }
            drawAutherRelationCharts(data);
        }
    );
}


//机构画图
//关键词词云
function drawWordCloud(data) {
    var mychart = echarts.init(document.getElementById('charts1'));
    var clouddata = data.keyWord.slice(1, -2).split(";");
    var wordData = new Array();
    clouddata.forEach(function (value) {
        var tmp = value.split(",");
        if (tmp[0] != null && tmp[0] != "null" && tmp[0] != "nullnull") {
            var tmpOb = {name: tmp[0], value: parseInt(tmp[1])}
            wordData.push(tmpOb);
        }
    });
    if (isNaN(wordData[0].value)) {
        wordData[0] = {name: "No data", value: 100};
    }
    var option = {
        // backgroundColor: '#fff',

        title: {
            text: "Word Cloud",
            textAlign: "auto",
            textStyle: {
                color: "#07035F",
            }
        },
        tooltip: {
            show: false
        },

        series: [{
            type: 'wordCloud',
            gridSize: 1,
            sizeRange: [12, 55],
            rotationRange: [-45, 0, 45, 90],
            textStyle: {
                normal: {
                    color: function () {
                        return 'rgb(' +
                            Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) + ')'
                    }
                }
            },
            left: 'center',
            top: 'center',
            // width: '96%',
            // height: '100%',
            width: 300,
            height: 200,
            // top: 20,
            data: wordData
        }]
    }
    mychart.setOption(option);
}

//年份折线图
function drawBarChart(data) {
    var mychart = echarts.init(document.getElementById('charts2'));
    var option = {
        title: {      //标题组件

            text: 'papers per year',
            textAlign: 'auto'
        },
        tooltip: {
            show: true,
            trigger: "item"
        }
        ,
        toolbox: {
            show: true,
            feature: {
                dataView: {
                    title: "数据视图",
                    show: true,
                    readOnly: true
                },
                restore: {
                    title: "还原",
                    show: true
                },
                magicType: {
                    show: true,
                    type: ['line', 'bar', 'stack', 'tiled']
                },
                saveAsImage: {
                    show: true,
                    type: 'png',
                    title: "保存为图片"
                }
            }
        }
        ,
        yAxis: {

            type: 'value'

        },
        xAxis: {
            data: ['2012', '2013', '2014', '2015', '2016', '2017', '2018', '2019']
        },
        series: [{
            type: 'line',
            data: data.docuCountByYear
        }]
    };
    mychart.setOption(option);
}

function exists(array,val) {
    for (var i = 0; i < array.length; i++) {
        if (array[i].name == val) {
            return true;
        }
    }
    return false;
}

function drawNewRelationChart(data,author_id) {
    var nameNodes = new Array();
    var nodes = new Array();
    var links = new Array();
    var index = 0;

    for (var i in data.content) {
        var obj = data.content[index];
        if (!exists(nameNodes,obj.a_name)) {
            nameNodes.push({name:obj.a_name,weight:obj.relation,id:obj.a_id,coworkpapers:obj.coworkpapers})
        }
        if (!exists(nameNodes,obj.b_name)) {
            nameNodes.push({name:obj.b_name,weight:obj.relation,id:obj.b_id,coworkpapers:obj.coworkpapers})
        }
        var tmpLink = {source: obj.a_name, target: obj.b_name ,weight:obj.relation};
        links.push(tmpLink);
        index++;
    }
    index = 0;
    for (var i in nameNodes) {
        var sb = 30;
        var wg = nameNodes[i].weight;
        if(index === 0){
            sb = 90;
        }

        else if(wg < 25){
            sb = 15 + wg*3
        }
        else{
            sb = 90;
        }
        var tmpObj = {name: nameNodes[index].name,value:wg ,symbolSize:sb,id:nameNodes[index].id,coworkpapers:nameNodes[index].coworkpapers};
        nodes.push(tmpObj);
        index++;
    }

    // console.log(nodes);
    // console.log(links);
    var option = {
        title: {
            text: "合作关系图谱"
        },

        backgroundColor: '#fff',

        tooltip: {
            show: true
        },

        series: [{
            type: 'graph',
            name: "相关学者",
            layout: 'force',
            roam:true,
            //symbol: 'pin',
            ribbonType: false,


            itemStyle: {
                normal: {
                    color: function () {
                        return 'rgb(' +
                            Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) + ')'
                    }

                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'top',//设置label显示的位置
                    formatter: '{b}',//设置label读取的值为value
                    textStyle: {
                        fontSize: '12rem'
                    },
                }
            },
            draggable: true,
            force: {
                edgeLength: 30,
                repulsion: 50,
                gravity:0.01
            },

            nodes: nodes,//同data,关系图的节点数据列表。
            links: links,
        }]
    };

    var mychart = echarts.init(document.getElementById('charts6'));
    mychart.on('click',function(param){
        var partner = param.data;
        console.log(author_id+"!!!"+partner.id);
        if(author_id==partner.id){
            alert("The two guys are the same person, choose another one");
        }
        else{
            $('#charts6-container~*').remove();
            getRequest(
                "/Portrait/Author/showABRelation?authorAId="+author_id+"&authorBId="+partner.id,
                function (res) {
                    correlation = res.content[0];
                    console.log(correlation);
                    var modalStr="<button id=\"relation-modal-btn\" style=\"display: none;\" type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">Relation</button><div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"><div class=\"modal-dialog\" role=\"document\"><div class=\"modal-content\">" +
                        "<div class=\"modal-header\">" +
                        "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                        "<h4 class=\"modal-title\" id=\"myModalLabel\">Relation</h4>" +
                        "</div><div class=\"modal-body\"></div></div></div></div>";
                    $('body').append(modalStr);

                    var predictStr = "";
                    if(correlation == null){
                        predictStr = "They haven't cooperated yet.   Maybe they will work together in the future.";
                    }
                    else{
                        if(correlation.a_affiliation == correlation.b_affiliation){
                            predictStr = "They are all in "+correlation.a_affiliation+".   They probably work together.";
                        }
                        else{
                            predictStr = "They belong to two distinct affiliations, but they have cooperated before.   They are likely to work again."
                        }
                    }
                    $('div.modal-body').append("<p class='text-warning'>"+predictStr+"</p>");
                    $('div.modal-body').append("<p class='text-primary'>Paper(s) they coworked:  </p>")
                    var paperlist = correlation.coworkpapers.split(";");
                    var listStr = "<ul class=\"list-group\">";
                    paperlist.forEach(function (paper,index) {
                        listStr += "<li class=\"list-group-item\">"+paper+"</li>"
                    })
                    listStr += "</ul>"
                    $('div.modal-body').append(listStr);

                    document.getElementById("relation-modal-btn").click();
                }
            )
        }
    });
    mychart.setOption(option);
}

function drawAutherChart(data) {
    var mychart = echarts.init(document.getElementById('chart3'));
    var keyWords = data.content[0].keywords;
    var wordData = new Array();
    for (var i in keyWords) {
        var tmpObj = {name: i, value: keyWords[i]};
        wordData.push(tmpObj);
    }

    var option = {
        backgroundColor: '#fff',

        tooltip: {
            show: false
        },

        series: [{
            type: 'wordCloud',
            gridSize: 1,
            sizeRange: [12, 55],
            rotationRange: [-45, 0, 45, 90],
            textStyle: {
                normal: {
                    color: function () {
                        return 'rgb(' +
                            Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) + ')'
                    }
                }
            },
            left: 'center',
            top: 'center',
            // width: '96%',
            // height: '100%',
            right: null,
            bottom: null,
            width: 300,
            height: 200,
            draggable: true,
            // top: 20,
            data: wordData
        }]
    };
    mychart.setOption(option);
}

function drawAutherRelationCharts(data) {
    var autherName = 'Author';
    var nodes = new Array();
    var links = new Array();

    nodes.push({name: autherName, value: 1});
    var index = 0;
    for (var i in data.content) {
        index++;
        var tmpObj = {name: i, value: 1};
        var tmpLink = {source: autherName, target: i, weight: data.content[i]}
        nodes.push(tmpObj);
        links.push(tmpLink);
    }

    var option = {
        title: {
            text: "合作关系图谱"
        },

        backgroundColor: '#fff',

        tooltip: {
            show: true
        },

        series: [{
            type: 'graph',
            name: "相关学者",
            layout: 'force',
            //symbol: 'pin',
            ribbonType: false,
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        textStyle: {
                            color: '#333'
                        },
                        position: 'bottom',//标签位置
                        distance: 5//标签距离图形的距离
                    },
                    nodeStyle: {
                        brushType: 'both',
                        borderColor: 'rgba(255,215,0,0.4)',
                        borderWidth: 1
                    },
                    linkStyle: {
                        type: 'line'
                    }
                },
                emphasis: {//高亮的图形样式
                    label: {
                        show: false
                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                    },
                    nodeStyle: {
                        //r: 30
                    },
                    linkStyle: {}
                }
            },
            //useWorker: false,
            minRadius: 15,
            maxRadius: 25,
            //gravity: 0.1,//节点受到的向中心的引力因子。该值越大节点越往中心点靠拢。
            //scaling: 0.1,
            //roam: 'move',
            nodes: nodes,//同data,关系图的节点数据列表。
            links: links,//节点间的关系数据。
            force: {
                repulsion: 1000//节点之间的斥力因子。
            }
        }]
    };


    var mychart = echarts.init(document.getElementById('chart5'));
    mychart.setOption(option);
    $('#chart5').resize();
}

function drawAutherYearCharts(data) {
    var yearDataTmp = data.content[0].publicationYearCount;
    var yearData = new Array();
    for (var i in yearDataTmp) {
        var tmpObj = {name: i, value: yearDataTmp[i]};
        yearData.push(tmpObj);
    }
    var option = {
        title: {
            text: "近年发表数量"
        },

        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                data: yearData,
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
                            formatter: '{b} ({d}%)'
                        },
                        labelLine: {show: true}
                    }
                }
            }
        ]
    };

    var mychart = echarts.init(document.getElementById('chart4'));
    mychart.setOption(option);
}

showByCountry();

function showByCountry() {
    var ul = "/Portrait/Affiliation/showByCountry";
    $.get(ul, function (data) {
        var tmpdata = data.content.slice(1, -2).split(";");
        var areaData = new Array();
        tmpdata.forEach(function (value) {
            var tmp = value.split(",");
            if (tmp[0] != null && tmp[0] != "null") {
                if (tmp[0] == 'USA') {
                    tmp[0] = 'United States';
                }
                var tmpOb = {name: tmp[0], value: parseInt(tmp[1])}
                if (tmpOb.value > 100) {
                    tmpOb.itemStyle = {color: 'rgb(255,0,23)'};
                } else if (tmpOb.value > 50) {
                    tmpOb.itemStyle = {color: 'rgb(255,242,43)'};
                } else if (tmpOb.value > 10) {
                    tmpOb.itemStyle = {color: 'rgb(187,255,123)'};
                } else if (tmpOb.value > 5) {
                    tmpOb.itemStyle = {color: 'rgb(143,255,173)'};
                } else {
                    tmpOb.itemStyle = {color: 'rgb(189,243,255)'};
                }
                areaData.push(tmpOb);
            }
            });
        var option = {
            backgroundColor: "#FFF",

            title: {
                text: "Degree of heat in Top 10 Countries",
                left: "40%",
                top: "20"
            },

            tooltip: {
                trigger: 'item',
                formatter: function (params) {
                    if (params.value) {
                        return params.name + '<br/>' + 'hotRate' + ':' + params.value;
                    } else {
                        return params.name + '<br/>' + 'hotRate' + ':' + '0';
                    }

                }
            },
            series: [
                {
                    name: 'areaMap',
                    type: 'map',
                    mapType: 'world',
                    roam: true,
                    itemStyle: {
                        emphasis: {label: {show: true}}
                    },
                    data: areaData
                }]
        };

        var mychart = echarts.init(document.getElementById('charts5'));
        mychart.setOption(option);
    });
}


function drawAffHotMap() {
    var data = [['University of British Columbia', 308], ['Peking University', 464], ['University of California', 1109],
        ['Nanjing University', 439], ['Carnegie Mellon University', 413], ['University of Luxembourg', 371],
        ['North Carolina State University', 339], ['Google', 348], ['Delft University of Technology', 318],
        ['Nanyang Technological University', 357]];

    var nodes = new Array();
    for (var i = 0; i < data.length; i++) {
        var tmpObj = {name: data[i][0], value: data[i][1], symbolSize: data[i][1] / 10};
        nodes.push(tmpObj);
    }


    var option = {
        title: {
            text: "Activation of Affiliation",
            textAlign: "auto"
        },
        series: [{
            type: 'graph',
            layout: 'force',
            itemStyle: {
                normal: {
                    color: function () {
                        return 'rgb(' +
                            Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) + ')'
                    }
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'top',//设置label显示的位置
                    formatter: '{b}:{c}',//设置label读取的值为value
                    textStyle: {
                        fontSize: '12rem'
                    },
                }
            },
            draggable: true,
            data: nodes,
            force: {
                edgeLength: 50,
                repulsion: 200,
                gravity: 0.1
            }
        }],

    };


    var mychart = echarts.init(document.getElementById('charts6'));
    mychart.setOption(option);

}

// drawDirectionChart(20);
//
// function drawDirectionChart(dirId){
//     var ul = "/Portrait/Direction/id/" + dirId.toString();
//     $.get(ul, function (data) {
//         drawDirectionYearChart(data);
//         drawDirectionAuthorChart(data);
//     });
//
// };

function drawDirectionYearChart(data) {


        var option = {
            title: {      //标题组件

                text: 'papers per year',
                textAlign: 'auto'
            },
            tooltip: {
                show: true,
                trigger: "item"
            }
            ,
            yAxis: {
                type: 'value'

            },
            xAxis: {
                data: ['2012', '2013', '2014', '2015', '2016', '2017', '2018', '2019']
            },
            series: [{
                type: 'line',
                data: data.content.docuCountByYear
            }]
        };


        var mychart = echarts.init(document.getElementById('charts7'));
        mychart.setOption(option);

}

function drawDirectionAuthorChart(data) {
    var authorData = data.content.authorOfDirection;
    var nodes = new Array();
    for(var i=0;i < authorData.length;i++){
        var authorName = authorData[i].author_name;
        var affName = authorData[i].affiliation;
        var tmpName = authorName+"("+affName+")";
        var authorValue = parseInt(authorData[i].publication_count);
        var tmpObj = {name:tmpName,value:authorValue,symbolSize:authorValue * 15}
        nodes.push(tmpObj);
    }

    // var data = [['University of British Columbia', 308], ['Peking University', 464], ['University of California', 1109],
    //     ['Nanjing University', 439], ['Carnegie Mellon University', 413], ['University of Luxembourg', 371],
    //     ['North Carolina State University', 339], ['Google', 348], ['Delft University of Technology', 318],
    //     ['Nanyang Technological University', 357]];
    //
    // var nodes = new Array();
    // for (var i = 0; i < data.length; i++) {
    //     var tmpObj = {name: data[i][0], value: data[i][1], symbolSize: data[i][1] / 10};
    //     nodes.push(tmpObj);
    // }
    // console.log(nodes);

    var option = {
        title: {
            text: "Activation of Affiliation",
            textAlign: "auto"
        },
        series: [{
            type: 'graph',
            layout: 'force',
            itemStyle: {
                normal: {
                    color: function () {
                        return 'rgb(' +
                            Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) +
                            ', ' + Math.round(Math.random() * 255) + ')'
                    }
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'top',//设置label显示的位置
                    formatter: '{b}:{c}',//设置label读取的值为value
                    textStyle: {
                        fontSize: '12rem'
                    },
                }
            },
            draggable: true,
            data: nodes,
            force: {
                edgeLength: 50,
                repulsion: 200,
                gravity: 0.1
            }
        }],

    };

    var mychart = echarts.init(document.getElementById('charts8'));
    mychart.setOption(option);
}