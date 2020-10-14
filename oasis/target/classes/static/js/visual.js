$(function () {

    var authorRowList = [];

    $('.search-btn').click(function () {
        var searchType = $("select option:selected").val();
        var searchContent = $("input[type=text]").val();
        if(!searchContent){
            alert("Input must be given!");
            return false;
        }
        if(searchType=="Affiliation"){searchAffliation(searchContent);}
        else if(searchType=="Author"){searchAuthor(searchContent);}
        else if(searchType=="Conference"){searchConference(searchContent);}
        else if(searchType=="Field"){searchField(searchContent);}
        return false;
    });

    function searchAffliation(affName) {
        var URL = "/Portrait/Affiliation/name/"+affName;
        getRequest(
            URL,
            function (res) {
                var dataList = res.content;
                if(!dataList){
                    alert("Sorry,we found nothing relevant");
                }
                else{
                    $('nav ~ *').remove();
                    affDisplay(dataList);
                }
            },
            function (err) {
                alert("Sorry,we found nothing relevant");
            }
        )
    }

    function affDisplay(dList) {
        var container = document.createElement('div');
        container.className = "container";
        var row;
        for(var i=0;i<dList.length;i++){
            if(i%3==0){
                if(row){container.appendChild(row);}
                row = document.createElement('div');
                row.className = "row";
            }
            var node = dList[i];
            var item = document.createElement('div');
            item.className="aff-item col-md-4 col-sm-4";
            var div = document.createElement('div');
            var h4 = document.createElement('h4');
            h4.className="text-info";
            var link = document.createElement('a');
            link.href="javascript:;";
            link.className="aff";
            link.innerText = node.affiliation_name;
            var p = document.createElement('p');
            p.className=node.affiliation_id;
            p.innerText = "id: " +node.affiliation_id;
            h4.appendChild(link);
            div.appendChild(h4);
            div.appendChild(p);
            item.appendChild(div);
            row.appendChild(item);
        }
        container.appendChild(row);
        $('body').append(container);

        $('body').delegate('a.aff','click',function () {
            var affId = $(this).parent().siblings()[0].className;
            affVisual(affId);

        })
    }
    function affVisual(affId) {
        $('body > nav ~ *').empty();
        var URL = '/Portrait/Affiliation/id/'+affId;
        getRequest(
            URL,
            function (res) {
                var data = res.content;
                console.log(res.content)
                if(!data.mostRefDocu || data.mostRefDocu.length==0){data.mostRefDocu = undefined;}
                var infoStr = "<div class=\"container\"><div class=\"row\"><div id=\"aff-card col-md-4\" class=\"well\">"+
                    "<div class=\"panel panel-default\"><div class=\"panel-body\"><p><span class=\"card-head\">Name: </span><span class=\"text-info aff-name\">"+
                    data.name+"</span></p><p><span class=\"card-head\">Id: </span><span class='text-info'>"+data.id+"</span></p>"+
                    "<p><span class=\"card-head\">Author Count: </span><span class='text-info'>"+data.authorCount+"</span></p>"+
                    "<p><span class=\"card-head\">Document Count: </span><span class='text-info'>"+data.docuCount+"</span></p>"
                    +"<div><button id='modal-btn' type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">Most Referenced Count</button></div>";
                $('body').append(infoStr);
                addModal(data.mostRefDocu);
                affCharts(data);

                var authorContainer = document.createElement("div"); authorContainer.className="container";
                $('body').append(authorContainer);
                for(var k=0;k<data.authorOfAffiliation.length;k++){
                    var author = data.authorOfAffiliation[k];
                    var item = document.createElement("div"); item.className="item";
                    var h3 = document.createElement("h3");
                    var link = document.createElement("a"); link.href="#"; link.id=author.author_id;link.innerText=author.author_name;
                    link.className="aff-author";    h3.appendChild(link);
                    var pubCount = document.createElement("div");
                    var span1 = document.createElement("span"); span1.className="card-head "; span1.innerText="Publication Count： ";
                    var span2 = document.createElement("span"); span2.innerText = author.publication_count
                    pubCount.appendChild(span1); pubCount.appendChild(span2);
                    item.appendChild(h3); item.appendChild(pubCount);
                    $(authorContainer).append(item);
                }
            },
            function (err) {
                console.log('Sorry,we found nothing relevant');
            }
        )

    }

    $('body').delegate("a.aff-author","click",function (event) {
        event = event || window.event;
        var aId = event.target.id;
        authorDetail(aId);
    })


    function addModal(objList) {
        var modalStr = "<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">"+
            "<div class=\"modal-dialog\" role=\"document\"><div class=\"modal-content\"><div class=\"modal-header\">"+
            "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>"+
            "<h4 class=\"modal-title\" id=\"myModalLabel\">Most Reference Count</h4></div></div></div></div>";
        $('body').append(modalStr);
        var modal = document.createElement('div'); modal.className="modal-body";
        var ul = document.createElement('ul'); ul.className="list-group";
        if(!objList){
            var li = document.createElement('li'); li.className="list-group-item";
            li.innerText = "No Most Referenced Paper!";
        }
        else {
            for (var k = 0; k < objList.length; k++) {
                var li = document.createElement('li');
                li.className = "list-group-item";
                var link = document.createElement('a');
                $.ajax({
                    url:"/document/DOI?doi="+objList[k].doi,
                    async:false,
                    success: function (res) {
                        link.href = res.content[0].pdflink;
                    },
                    error:function(err) {
                        alert("link has been deprecated.");
                        link.href = "#";
                    }
                });
                link.innerText = objList[k].title;
                li.appendChild(link);
                ul.appendChild(li);
            }
        }
        modal.appendChild(ul).appendChild(li);
        $('.modal-content').append(modal);
        $('#myModal').modal({show:false});
    }




    function authorDisplay(dList) {
        $('body > nav ~ *').remove();
        var container = document.createElement('div');
        container.className = "author-container container";
        $('body').append(container);
        var row;
        for(var i=0;i<dList.length;i++){
            if(i%3==0){
                // if(row){container.appendChild(row);}
                if(row){authorRowList.push(row);}
                row = document.createElement('div');
                row.className="row";
            }
            var node = dList[i]; if(!node.keywords){node.keywords = {}; node.keywords.None = "";}
            if(!node.paperTitles){node.paperTitles=[];node.paperTitles.push("None");}
            var col = document.createElement('div');  col.className = "col-md-4 col-sm-4";
            var panel = document.createElement('div');  panel.className="panel panel-primary";
            var pHead = document.createElement('div');  pHead.className="panel-heading";
            var pTitle = document.createElement('h3'); pTitle.id = node.author_id;
            var link = document.createElement('a');link.href="javascript:;";link.className="author-link";link.innerText=node.author_name;
            pTitle.appendChild(link);
            pHead.appendChild(pTitle);
            panel.appendChild(pHead);
            var pBody = document.createElement('div'); pBody.className="panel-body";
            var aId = document.createElement('span'); aId.className="author-id"; aId.id=node.author_id;
            var affId = document.createElement('span'); affId.className="aff-id"; affId.id=node.affiliation_id;
            var pAff = document.createElement('p'); var pKey = document.createElement('p'); var pCount = document.createElement('p');
            var sAff1 = document.createElement('span'); sAff1.className="card-head"; sAff1.innerText="Affiliation: ";
            var sAff2 = document.createElement('a'); sAff2.href="#"; sAff2.className="aff-link" ;sAff2.innerText=node.affiliation;
            pAff.appendChild(aId);pAff.appendChild(affId) ;pAff.appendChild(sAff1); pAff.appendChild(sAff2);
            var sKey1 = document.createElement('span'); sKey1.className="card-head"; sKey1.innerText="Keywords:";
            var sKey2 = document.createElement('span'); sKey2.className="text-info";
            sKey2.innerText = (function (list) {
                var str = ""+list[0];
                for(var j=1;j<5 && j<list.length;j++){
                    str += ", " + list[j];
                }
                return  str.replace(/: \d+/g," ");
            })(Object.keys(node.keywords))
            pKey.appendChild(sKey1); pKey.appendChild(sKey2);
            var sCount1 = document.createElement('span'); sCount1.className="card-head"; sCount1.innerText="Publication Count: ";
            var sCount2 = document.createElement('span'); sCount2.className="text-info"; sCount2.innerText=node.publication_count;
            pCount.appendChild(sCount1); pCount.appendChild(sCount2);
            var paper = document.createElement('p');
            var paper1 = document.createElement('span'); paper1.className="card-head"; paper1.innerText="Paper: ";
            var paper2 = document.createElement('span'); paper2.className="text-info"; paper2.innerText=node.paperTitles[0];
            paper.appendChild(paper1); paper.appendChild(paper2);
            pBody.appendChild(pAff); pBody.appendChild(pKey); pBody.appendChild(pCount); pBody.appendChild(paper);
            panel.appendChild(pBody);
            col.appendChild(panel);
            row.appendChild(col);
        }
        // container.appendChild(row);
        authorRowList.push(row);
        // $('body').append(container);
        var paginationNode = $("<div class=\"turn-page\"><nav aria-label=\"Page navigation example\"><ul class=\"pagination\"></ul></nav></div>");
        $('body').append(paginationNode);
        $('.author-container').delegate('a.aff-link','click',function (event) {
            event = event || window.event;
            var affId = $(event.target).parent().children('.aff-id').attr('id');
            affVisual(affId);
        });
        $('.author-container').delegate('a.author-link','click',function (event) {
            var id= $(event.target).parent().attr('id')
            authorDetail(id);
        })
        turnPage(".author-container",paginationNode);

    }
    $("body").delegate("#jumb .row .col-md-7 p a",'click',function (event) {
        event = event||window.event;
        var id = event.target.id;
        affVisual(id);
    })
    /*三个全局变量*/
    var numPerPage = 2;
    var pageNum;
    var currentPageNum = 1;

    function turnPage(className,paginationNode) {
        pageNum = Math.ceil(authorRowList.length/numPerPage);
        showIcon(1);
        showContent(className);
        $('ul.pagination').delegate('a.page-link','click',function(event){
            event = event || window.event;
            var num = event.target.innerText;
            // $('author-container').empty();
            if(!isNaN(num)){
                currentPageNum = num;
                showIcon(num);
                showContent(className);
            }else if(num=="Previous"){
                if(currentPageNum>1){
                    currentPageNum--;
                    showIcon(currentPageNum);
                    showContent(className);
                }
            }else if(num=="Next"){
                if(currentPageNum<pageNum){
                    currentPageNum++;
                    showIcon(currentPageNum);
                    showContent(className);
                }
            }
        })

    }

    function showIcon(index){
        var paginatioin = $('ul.pagination'); paginatioin.empty();
        paginatioin.append(getNode("previous"));
        var rightNode,leftNode;
        var start = 1, end = pageNum;
        start = index>2?index-1:1;
        var temp = ++index;
        index--;
        end = index<pageNum?(temp):pageNum;
        if(start-1>1){
            /*需要右边的...*/
            leftNode = getNode("...");
            paginatioin.append(leftNode);
        }
        for(var i=start;i<=end;i++){
            var node;
            if(i==index){node=getNode(i,true);}
            else {node=getNode(i);}
            paginatioin.append(node);
        }
        if(end+1<pageNum){
            rightNode = getNode("...");
            paginatioin.append(rightNode);
        }
        paginatioin.append(getNode("next"));


    }

    function getNode(num,active){
        var node;
        if(num=="previous"){
            node = $("<li class=\"page-item previous\"><a class=\"page-link\" href=\"javascript:;\">Previous</a></li>");
        }
        else if(num=="next"){
            node = $("<li class=\"page-item next\"><a class=\"page-link\" href=\"javascript:;\">Next</a></li>");
        }
        else if(!isNaN(num)){
            if(active){
                node = $("<li class=\"page-item active\"><a class=\"page-link\" href=\"javascript:;\">"+num+"</a></li>");
            }
            if(!active){
                node = $("<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:;\">"+num+"</a></li>");
            }
        }
        else{
            node = $("<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:;\">...</a></li>");
        }
        return node;
    }

    function showContent(className){
        $('div.author-container').empty();
        for(var k=currentPageNum*2-1;k<=currentPageNum*2&&k<=authorRowList.length;k++){
            //k-1才是真正的下标
            $('div.author-container').append(authorRowList[k-1]);
        }
    }
    
    function searchAuthor(authorName) {
        var URL = "/Portrait/Author/name/"+spaceReplace(authorName);
        getRequest(
            URL,
            function (res) {
                if(!res.content){
                    alert('结果为空');
                }
                else{
                    authorDisplay(res.content);
                }
            },
            function (err) {
                alert("Not found");
            }

        )
    }


    function searchField(FieldName) {
        var URL = "/Portrait/Direction/name/"+spaceReplace(FieldName);
        getRequest(
            URL,
            function (res) {
                data = res.content;
                if(data){
                    showFieldList(data);
                }
                else{
                    alert("Sorry, we found nothing relevant");
                }
            },
            function () {
                alert("Sorry, we found nothing relevant");
            }
        )
    }
})