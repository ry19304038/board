/********************************************************************************

	SYNCER 〜 知識、感動をみんなと同期(Sync)するブログ

	* 配布場所
	https://syncer.jp/jquery-modal-window

	* 最終更新日時
	2015/08/17 15:55

	* 作者
	あらゆ

	** 連絡先
	Twitter: https://twitter.com/arayutw
	Facebook: https://www.facebook.com/arayutw
	Google+: https://plus.google.com/114918692417332410369/
	E-mail: info@syncer.jp

	※ バグ、不具合の報告、提案、ご要望など、お待ちしております。
	※ 申し訳ありませんが、ご利用者様、個々の環境における問題はサポートしていません。

********************************************************************************/


$(function(){

	function popupImage() {
	  var popup = document.getElementById('js-popup');
	  if(!popup) return;

	  var blackBg = document.getElementById('js-black-bg');

	  var blackBg = document.getElementById('js-black-bg');
	  var closeBtn = document.getElementById('js-close-btn');
	  var showBtn = document.getElementById('js-show-popup');

	  closePopUp(blackBg);
	  closePopUp(closeBtn);
	  closePopUp(showBtn);
	  function closePopUp(elem) {
	    if(!elem) return;
	    elem.addEventListener('click', function() {
	      popup.classList.toggle('is-show');
	    });
	  }
	}
	popupImage();
} ) ;
