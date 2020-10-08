$(function () {
    // var URL = "/browse/TopTenPublicationAuthor";
    var URL = "/Portrait/Author/showByHeat"
    getRequest(
        URL,
        function (res) {
            // console.log(res);
            showRank(res.content);
        }
    )

    getRequest(
        "/Portrait/Affiliation/showByCountry",
        function (res) {
            list = res.content.split(";")
            console.log(list)
            showRegionRank(list);
        }
    )
    $('body').delegate("td>a",'click',function (event) {
        event = event || window.event;
        id = event.target.id;
        authorDetail(id);
    })

    // showChart();

    function showRank(list) {
        var classes = ['danger','warning','info','success','active'];
        for(var i=0;i<list.length && i<15;i++){
            var temp = document.createElement("tr");
            var row = $(temp);
            if(i%2==0){row.addClass(classes[(i%10)/2]);}
            var rank = $('<td>'+(i+1)+'</td>')
            var id = $('<td>'+list[i].author_id+"</td>");
            var name = $('<td><a href="#" id=\"'+list[i].author_id+'\">'+list[i].author_name+"</a></td>");
            var affiliation = $('<td>'+list[i].affiliation+"</td>");
            var count = $('<td>'+list[i].publication_count+"</td>");
            var heat = $('<td>'+list[i].heat+'</td>')
            row.append(rank).append(id).append(name).append(affiliation).append(count).append(heat);
            $("tbody.author").append(row);
        }
    }

    function showRegionRank(list) {
        var classes = ['danger','warning','info','success','active'];
        for(var i = 1;i<=15 && i<list.length;i++){
            var pair = list[i].split(",");
            var rank = $('<td>'+i+'</td>');
            var region = $('<td>'+pair[0]+"</td>");
            var heat = $('<td>'+pair[1]+"</td>");
            var temp = document.createElement("tr");
            var row = $(temp);
            if(i%2==0){row.addClass(classes[(i%10)/2]);}
            row.append(rank).append(region).append(heat);
            $("tbody.region").append(row);
        }
    }

    // function showChart(data) {
    //     var chartNode = document.getElementById("chart");
    //     chartNode.height = '500px';
    //     chartNode.width = '500px';
    //     var chart = echarts.init(chartNode);
    //     var option = {
    //         title:{ text: 'Document Distribution', subtext:'Conference',left:"center"},
    //         series:[{
    //             type:'pie',
    //             radius:'55%',
    //             center:['50%','50%'],
    //             selectedMode:'single',
    //             data:[{name:'IEEE',value:1000}],
    //         }]
    //     }
    //
    //     chart.setOption(option);
    //
    // }

    // drawAffHotMap();
})