$(document).ready(function(){

   $(".cartitemdelete").click(function(){
   var did = $(this).data('id');
   
     $.ajax({
	    url: "cart_delete_proc.do?pid="+did,
	    success: function(result) {
	    alert("상품이 삭제되었습니다!");
	    reloadModalContent();
			}
  		});
	function reloadModalContent() {  
    	 $('#CartModal .modal-content').load('cartModal.do');
  }

});


});