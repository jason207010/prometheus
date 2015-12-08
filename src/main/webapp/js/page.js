var maxShowPages = 10;
var halfShowPages = maxShowPages / 2;
function showPages(totalPages , curPage){
    var page = $('.page');
    var nav = $('<nav></nav>');
    var ul = $('<ul class="pagination"></ul>');
    page.append(nav);
    nav.append(ul);

    var previousLi;
    if(curPage == 1){
        previousLi = $('<li class="disabled"><span><span aria-hidden="true">&laquo;</span></span></li>');
    } else {
        var previousA = $('<a href="#" onclick="goToPage(' + (curPage - 1) + ')"><span>&laquo;</span></a>');
        previousLi = $('<li></li>');
        previousLi.append(previousA);
    }
    ul.append(previousLi);

    var start = 0;
    var end = 0;

    if(totalPages <= maxShowPages){
        start = 1;
        end = totalPages;
    } else {
        if(curPage - halfShowPages <= 0){
            start = 1;
            end = maxShowPages;
        } else if(curPage + halfShowPages >= totalPages){
            start = totalPages - maxShowPages + 1;
            end = totalPages;
        } else {
            start = curPage - halfShowPages;
            end = start + maxShowPages - 1;
        }
    }

    for(var i = start ; i <= end ; ++i){
        var a = $('<a href="#" onclick="goToPage(' + i + ')">' + i + '</a>');
        var li = $('<li></li>');
        if(i == curPage){
            li.addClass('active');
        }
        li.append(a);
        ul.append(li);
    }

    var nextLi;
    if(curPage == totalPages){
        nextLi = $('<li class="disabled"><span><span aria-hidden="true">&raquo;</span></span></li>');
    } else {
        var nextA = $('<a href="#" onclick="goToPage(' + (curPage + 1) + ')"><span>&raquo;</span></a>');
        nextLi = $('<li></li>');
        nextLi.append(nextA);

    }
    ul.append(nextLi);
}

function goToPage(pageNo){
    var curPage = $(':hidden[name="curPage"]');
    curPage.val(pageNo);
    $('#pageForm').submit();
}