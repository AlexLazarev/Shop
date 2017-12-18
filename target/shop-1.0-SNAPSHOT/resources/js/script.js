(function($){

	//Acc
	//------------------------------------------------------------------------------------------------------------------
	$(".header-acc").click(function () {
		$('.header-accwindow').addClass('active');
		$('.recyclebin').removeClass('active');
	});

	$(".header-accwindow__close").click(function () {
		$('.header-accwindow').removeClass('active');
	});


    //Recycle bin
    //------------------------------------------------------------------------------------------------------------------
	$(".header-rbcount").click(function () {
		$('.recyclebin').addClass('active');
		$('.header-accwindow').removeClass('active');
	});

	$(".recyclebin-header__back").click(function () {
		$('.recyclebin').removeClass('active');
	});

})(jQuery);


