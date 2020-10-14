function sm() {
    var ul = "/document/" + $("select").val() + '/' + $("input#content").val();

    $.get(ul, function (data, status) {
        data.content.forEach(function (index) {
            console.log(index);
        });
    });
};

var page = 0;
var pageNum;
var pageSize = 6;
var itemSize;
var items = new Array();
var previousbutton;
var nextbutton;
previousbutton = document.createElement("button");
previousbutton.innerText = "Previous";
previousbutton.className = "pre-btn";
previousbutton.onclick = previous;
nextbutton = document.createElement("button");
nextbutton.innerText = "Next";
nextbutton.className = "next-btn";
nextbutton.onclick = next;


function next() {
    page ++;
    updatepage();
}

function previous(){
    page--;
    updatepage();
}

function toPage(pageNum) {
    page = pageNum
    updatepage();
}

function clear(){
    page =0;
    items = new Array();

}

function complexSearch() {
    clear();
    var author = 'authorname=' + $("input.search-input[name = 'authorname']").val();
    var affiliation = '&affiliation=' + $("input.search-input[name = 'affiliation']").val();
    var year = '&year=' + $("input.search-input[name = 'year']").val();
    var keywords = '&keywords=' + $("input.search-input[name = 'keywords']").val();
    var url = "/document/complex?" + author + affiliation + year + keywords;
    $.get(url, function (data) {
        if(!data.content){
            notFound();
            return;
        }
        itemSize = data.content.length;
        pageNum = Math.ceil(data.content.length/pageSize);
        data.content.forEach(function (eachDoc, index) {
            var item = document.createElement("div");
            var title = document.createElement("h5");
            var titleNode = document.createTextNode(eachDoc.title);
            var titleLink = document.createElement("a");
            titleLink.href = "javascript:;";
            titleLink.appendChild(titleNode);
            title.appendChild(titleLink);
            item.appendChild(title);

            var author = document.createElement("p");
            var aspan = document.createElement("span");
            var atext = document.createTextNode("Author:  ");
            aspan.appendChild(atext);
            author.appendChild(aspan);
            var authorNode = document.createTextNode(eachDoc.author);
            author.appendChild(authorNode);
            item.appendChild(author);

            var doi = document.createElement("p");
            var dspan = document.createElement("span");
            var dtext = document.createTextNode("DOI: ");
            dspan.appendChild(dtext);
            doi.appendChild(dspan);
            var doiNode = document.createTextNode(eachDoc.doi);
            doi.appendChild(doiNode);
            doi.className = 'doi';
            item.appendChild(doi);

            var year = document.createElement("p");
            var yspan = document.createElement("span");
            var ytext = document.createTextNode("PublicationYear:  ");
            yspan.appendChild(ytext);
            year.appendChild(yspan);
            var yearNode = document.createTextNode(eachDoc.publicationYear);
            year.appendChild(yearNode);
            item.appendChild(year);

            var aff = document.createElement("p");
            var fspan = document.createElement("span");
            var ftext = document.createTextNode("Affiliation:  ");
            fspan.appendChild(ftext);
            aff.appendChild(fspan);
            var affNode = document.createTextNode(eachDoc.affiliation);
            aff.appendChild(affNode);
            item.appendChild(aff);

            var keyWord = document.createElement("p");
            var kspan = document.createElement("span");
            var ktext = document.createTextNode("Keyword:  ");
            kspan.appendChild(ktext);
            keyWord.appendChild(kspan);
            var keyWordNode;
            if(!eachDoc.keyWord){
                keyWordNode = document.createElement("b");
                var keytext = document.createTextNode("None");
                keyWordNode.appendChild(keytext);
            }else{
                keyWordNode = document.createTextNode(eachDoc.keyWord);
            }
            keyWord.appendChild(keyWordNode);

            item.appendChild(keyWord);
            item.className = "result-content";
            // itemSize = index;
            items.push(item);
        });
        updatepage();
    })
}

function updatepage() {
    previousbutton.disabled = page<=0?true:false;
    nextbutton.disabled = page >= (pageNum-1)?true:false;
    $("body > .container ~ *").remove();
    var resultStr = "<div id=\"result\"><div class=\"container\"></div></div>";
    $("body").append(resultStr);
    for (var i = page * pageSize; i < page * pageSize + pageSize && i < itemSize; i++) {
        // var temp = document.createElement("div");
        // temp.className = "result-content";
        // temp.appendChild(items[i]);
        $("#result .container").append(items[i]);
    }
    var btnNav = $("<div class=\"btn-nav\"></div>");
    btnNav.append(previousbutton);
    var str =  "<div id=\"page-control\" display=\"inline-block\">"+ (page+1) + " / " + pageNum + "</div>";
    btnNav.append(str);
    btnNav.append(nextbutton);
    $("#result .container").append(btnNav);
    $("body > .container").css("marginBottom",0);
}


function notFound() {
    $("body > .container ~ *").remove();
    var img = $("<div class='not-img'><img src='/img/notfound.png' alt='result not found' /></div>");
    $("body > .container").css("marginBottom",0);
    $("body").append(img);
    alert("Sorry, we found nothing relevant.");
}