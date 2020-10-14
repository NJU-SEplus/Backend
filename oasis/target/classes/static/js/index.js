$(function () {

    var resultList;
    var items = new Array();
    var pageSize = 6; //页面最大展示的项数
    var page = 0; //定义当前页面
    var pageNum = 0;
    var searchBtn = $("#search-btn input[type=button]");

    var previousBtn = document.createElement("button");
    previousBtn.className = "pre-btn";
    previousBtn.onclick = previous;
    previousBtn.innerText="Previous";
    var nextBtn = document.createElement("button");
    nextBtn.className = "next-btn";
    nextBtn.onclick = next;
    nextBtn.innerText = "Next";

    function previous(){
        if(page<=0){return;}
        page--;
        updatePage();
    }

    function next(){
        if(page>=pageNum){return;}
        page++;
        updatePage();
    }

    searchBtn.click(function () {
        var option = $("select option:selected");
        var searchType = option.val();
        var searchVal  = $(".search-div input[type=text]").val();
        if(!searchVal){
            alert('Something must be given');
        }
        searchVal = spaceReplace(searchVal);
        var URL = "/document/"+searchType+"/"+searchVal;

        getRequest(
            URL,
            function (res) {
                if(!res.content){
                    notFound();
                }
                else{
                    resultList = res.content;
                    process(resultList);
                    updatePage();
                }
            },
            function (err) {
                notFound();
            })
    });

    function process(list) {
        pageNum = Math.ceil(list.length/pageSize);
        for(var i=0;i<list.length;i++){
            var docstr = "";
            var title = list[i].title;
            var author = list[i].author;
            var affi = list[i].affiliation;
            var doi = list[i].doi;
            var year = list[i].publicationYear;
            var keywords = list[i].keyWord;
            docstr += resultStr(title,author,affi,doi,keywords,year);
            items.push(docstr);
        }
    }

    function updatePage() {

        var str = "";
        for (var i = page * pageSize; i < (page + 1) * pageSize && i < items.length; i++){
            str += items[i];
        }
        $(".search-container ~ *").remove();
        $("body").append("<div id=\"result\"><div class=\"container\"></div></div>");
        $("#result .container").append(str);
        previousBtn.disabled = page<=0? true:false;
        nextBtn.disabled = page>=(pageNum-1)?true:false;
        var btnNav = $("<div class=\"btn-nav\"></div>");
        btnNav.append(previousBtn);
        var str =  "<div id=\"page-control\" display=\"inline-block\">"+ (page+1) + " / " + pageNum + "</div>";
        btnNav.append(str);
        btnNav.append(nextBtn);
        $("#result .container").append(btnNav);
    }

    function spaceReplace(str) {
        return str.replace(/\s+/g,"%20");
    }

    function notFound() {
        $("body > .search-container ~ *").remove();
        var img = $("<div class='not-img'><img src='/img/notfound.png' alt='result not found' /></div>");
        $("body > .container").css("marginBottom",0);
        $("body").append(img);
        alert("Sorry, we found nothing relevant.");
    }
})

