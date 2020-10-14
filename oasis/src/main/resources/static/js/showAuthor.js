    function authorDetail(id) {
        var Hindex = 0;
        var paperList = [];
        var authorId = id;
        $('nav ~ *').remove();
        $.ajax(
            '/Portrait/Author/Hindex/'+id,
            {
                async:false,
                success:function (res) {
                    Hindex = res.content;
                    if(Hindex==null || Hindex=="null"){Hindex=0;}
                }
            }
        )
        getRequest(
            "/Portrait/Author/id/"+authorId,
            function (res) {
                var node = res.content[0];
                //console.log(node);
                var jumbo = "<div class=\"container jumbotron-container\"><div class=\"jumbotron\" id='jumb'><div class=\"row\"><div class=\"col-md-7\">"+
                    "</div><div class=\"col-md-5\"><div id=\"chart3\"></div></div></div></div></div>";
                $('body').append(jumbo);
                var h1 = document.createElement('h1');
                var a_name = document.createElement("a"); a_name.href = "#"; a_name.innerText = node.author_name; a_name.id = node.author_id;
                //h1.innerText = node.author_name;
                h1.append(a_name);
                $('.col-md-7').append(h1);
                var pStr = "<p><a href=\"#\">"+node.affiliation+"</a> <span class=\"H-index\">H-index: "+Hindex+"</span></p>";
                $('.col-md-7').append(pStr);
                if(!node.keywords){node.keywords={None:"None"};}
                var keys = Object.keys(node.keywords);
                for(var k=0;k<10&&k<keys.length;k++){
                    var tmp = document.createElement("span"); tmp.className="keyword";
                    tmp.innerText = keys[k];
                    $(".col-md-7").append(tmp);
                }
                $('#chart3').css("height",270);
                $('.col-md-7>p>a').attr("id",node.affiliation_id);
                //Jumbo完成
                drawAutherChart(res);
                var itemStr = "<div class=\"container-fluid\"><div class=\"col-md-4\">"+
                    "<div id=\"chart4\"></div><div id=\"chart5\"></div>"+
                    "</div><div class=\"col-md-8\"></div></div>";
                $('body').append(itemStr);
                $('#chart4').css("height",400);
                $('#chart5').css("height",400);
                for(var k=0;k<node.paperTitles.length;k++){
                    $.ajax(
                        "/document/title/"+spaceReplace(node.paperTitles[k]),
                        {
                            async: false,
                            success:function (res) {
                                $.ajax(
                                    "/document/DOI?doi="+res.content[0].doi,
                                    {
                                        async:false,
                                        success:function (data) {
                                            paperList.push(data.content[0]);
                                        }
                                    }
                                )
                                // res.content[0];
                            }
                        }
                    )
                }
                var itemList = [];
                paperList.forEach(function (obj) {
                    var item = document.createElement("div"); item.className="item";
                    var h3 = document.createElement("h3");
                    var link = document.createElement("a"); link.href=obj.pdflink; link.innerText=obj.title;
                    h3.appendChild(link);
                    var para1 = document.createElement("p");
                    var span = document.createElement("span"); span.id="year"; span.innerText=obj.publicationYear;
                    para1.appendChild(span);
                    var para2 = document.createElement("p"); para2.className="text-info";para2.innerText=questionReplace(obj.author);
                    item.appendChild(h3);item.appendChild(para1);item.appendChild(para2);
                    $(".container-fluid .col-md-8").append(item);
                })


                drawAutherYearCharts(res);
                //showPartner(authorId);
            },
            function (err) {
                alert(err);
            }
        )

        $('body').delegate('#jumb div.col-md-7>h1>a','click',function (event) {
            event = event || window.event;
            $("nav ~ *").remove();
            var chartStr = "<div id=\"charts6-container\" style=\"height: 100%; width: 100%;\">" +
                "<div id=\"charts6\" style=\"height: 600px; width: 1200px;\"></div>" +
                "</div>";
            $("body").append(chartStr);
            getRequest(
                '/Portrait/Author/showNewRelationById/'+authorId,
                function (res) {
                    // console.log(res.content);
                    drawNewRelationChart(res,authorId)
                }
            )

        })

        $("body").delegate("#jumb .row .col-md-7 p a",'click',function (event) {
            event = event||window.event;
            var id = event.target.id;
            affVisual(id);
        })
    }

    function showPartner(id) {
        getRequest(
            "/Portrait/Author/Partners/"+id,
            function (res) {
                drawAutherPartnerCharts(res);
            }
        )
    }

    function getHindex(id){
        $.ajax(
            '/Portrait/Author/Hindex/'+id,
            {
                async:false,
                success:function (res) {
                    Hindex = res.content;
                    if(Hindex==null || Hindex=="null"){Hindex=0;}
                }
            }
        )

    }