/**
 * 
 */

"use strict"


var likeBtns = document.querySelectorAll(".har-like");
var feedLike = document.getElementById('like');


for (var l of likeBtns) {
  var no = l.getAttribute("har-like-no");
  var lType = l.getAttribute("har-like-type");

  $.ajax("likeCheck", {
    method: "POST",
    data: "no=" + no + "&lType=" + lType,
    async: false,
    success: function(data) {
      console.log(no, data, "피드라이크!");

      if (data == "no") {
        if (lType == 1) {
          feedLike.style.backgroundPosition = "-9px -9px";
        } else {
          l.style.color = "#666";
        }
        /* var feedLike = document.querySelector(".like");*/
      } else if (data == "yes") {
        if (lType == 1) {
          feedLike.style.backgroundPosition = "-38px -9px";
        } else {
          l.style.color = "blue";
        }
        /* var feedLike = document.querySelector(".like");*/

      }
    },
    error: function(data) {
      console.log(data);
    }
  });
}


function likeCheck(e) {
  var likeBtn = e.target;
  var no = likeBtn.getAttribute("har-like-no");
  var url = '';

  if (likeBtn.getAttribute("har-like-type") == 1) {
    url = "like";
  } else if (likeBtn.getAttribute("har-like-type") == 2) {
    url = "comment/like";
  } else if (likeBtn.getAttribute("har-like-type") == 3) {
    url = "reComment/like";
  }

  $.ajax(url, {
    method: "POST",
    data: "no=" + no,
    success: function(data) {
      console.log(data);
      if (data == "yes") {
        likeBtn.style.color = "blue";
      } else if (data == "no") {
        likeBtn.style.color = "#666";
      }
    },
    error: function(data) {
      console.log(data);
    }
  });

  location.reload();
}




function reCommentAdd(cmtNo, tgNo, fdNo) {
  var cmtForm = document.getElementById("har-comment-add");
  var originForm = cmtForm.innerHTML;

  cmtForm["action"] = "reComment/add";

  cmtForm.innerHTML = "<input type='hidden' name='commentNo' value='" + cmtNo + "'/>"
    + "<input type='hidden' name='taggedNo' value='" + tgNo + "'/>"
    + "<input type='hidden' name='no' value='" + fdNo + "' />"
    + "<input type='text' name='content' placeholder='댓글을 달아주세요.'  class='har-comment-text'/>"
    + "<input type='submit' value='등록' class='har-comment-btn'>";
}


var reCmtInputList = document.querySelectorAll(".har-cmt-input");
var reCmtConfirm = document.querySelectorAll(".har-cmt-confirm");

for (var e of reCmtInputList) {
  e.style.display = "none";
}

for (var e of reCmtConfirm) {
  e.style.display = "none";
}

function cmtUpdate(e) {
  /* console.log("e.target", e.target); */
  var recommentDiv = e.target.parentElement;
  recommentDiv = recommentDiv.parentElement;

  recommentDiv.querySelector(".har-cmt-input").style.display = "";
  recommentDiv.querySelector(".har-cmt-confirm").style.display = "";
  recommentDiv.querySelector(".har-cmt-content").style.display = "none";
  /* recommentDiv.querySelector(".har-like-box").style.top = 15px; */
  recommentDiv.querySelector(".har-cmt-update").style.display = "none";
}

function cmtConfirm(e) {
  var recommentDiv = e.target.parentElement;
  recommentDiv = recommentDiv.parentElement;
  var content = recommentDiv.querySelector(".har-cmt-input").value;
  var no = recommentDiv.getAttribute("har-cmt-no");
  recommentDiv.querySelector(".har-cmt-input").style.display = "none";
  recommentDiv.querySelector(".har-cmt-content").style.display = "";

  var url = '';

  if (recommentDiv.getAttribute("har-cmt-type") == 1) {
    url = "comment/update";
  } else {
    url = "reComment/update";
  }

  $.ajax(url, {
    method: "POST",
    data: "no=" + no + "&content=" + content,
    success: function() {
      alert("성공했습니다.");
    },
    error: function() {
      alert("실패했습니다.");
    }
  });

  location.reload();
}



