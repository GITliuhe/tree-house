/**
 * Created by yangjian on 17-8-15.
 */

(function($) {

	//ѡ����λ
	$.fn.selectSeat = function() {
		$(this).find('span').addClass("selected");
	}

	//ȡ��ѡ����λ
	$.fn.unselectSeat = function() {
		$(this).find('span').removeClass("selected");
	}

	//�ж���λ�Ƿ�ѡ��
	$.fn.hasSelected = function() {
		return $(this).find('span').hasClass("selected");
	}

	// ���� css �ļ�
	var js = document.scripts, script = js[js.length - 1], jsPath = script.src;
	var cssPath = jsPath.substring(0, jsPath.lastIndexOf("/") + 1)+"css/seat.css"
	$("head:eq(0)").append('<link href="'+cssPath+'" rel="stylesheet" type="text/css" />');

	var __seats__ = function(options) {

		var defaults = {
			rows : 5, //��λ����
			cols : 15, //��λ����
			size : 40, //��λ�ĳߴ磬��λ������
			thre_id : 0, //�糡ID
			hall_id : 0, //��ID
			movie_id : 0, //��Ӱ����ID
			step : 1, //�������裬1��������2������Ʊ�ۣ�3����Ʊ
			onSelected : function(seat) { //ѡ����λʱ��Ļص������� step = 3(��Ʊ)ʱ��Ч
				console.log(seat);
			},
			onUnselected : function(seat) { //ȡ����λ��ʱ��ص�
				console.log(seat);
			},
			onerror : function(msg) {

			},
			maxTicketNumber : 5, //��๺Ʊ����
			selected : {}, //��ѡ�е���λ
			datas : {}
		};
		options = $.extend(defaults, options);
		var seats = {};
		var o = {};
		var ticketNumber = 0; //�ѹ�Ʊ��
		if ( getObjLength(options.datas) > 0 ) {
			seats = options.datas;
		}
		var seatColors = {};

		//����Ԫ��
		function create() {
			var $table = $('<table class="seat-table animated-seat" cellpadding="0" cellspacing="0"></table>');
			for (var r = 1; r <= options.rows; r++) {
				var $tr = $('<tr></tr>');
				for (var c = 1; c <= options.cols; c++) {
					var sid = r+"_"+c; //��λID
					var $td = $('<td data-row="'+r+'" data-col="'+c+'" id="'+sid+'"></td>');
					var $seat = $('<span class="seat"></span>');
					$seat.css({
						"width" : options.size + 'px',
						"height" : options.size + 'px'
					});
					try {   //���ñ߿�
						$td.data('thre_id', seats[sid].thre_id);
						$td.data('hall_id', seats[sid].hall_id);
						$td.data('movie_id', seats[sid].movie_id);
						$td.data("price", seats[sid].price);
						//������λ�߿���ɫ
						if(seats[sid].color) {
							$seat.css({"border-color":seats[sid].color});
							$td.data("color", seats[sid].color);
						}
					} catch (e) {}

					//��ѡ���¼�
					$td.on("click", function() {
						$(this).find('span').toggleClass("selected");
						var row = $(this).data('row'), col = $(this).data('col');
						var key = row+"_"+col;

						//���ݲ�ͬ�Ĳ���ִ�в�ͬ�Ĳ���
						switch (options.step) {

							case 1: //����
								if ($(this).hasSelected()) {
									seats[key] = {
										"row" : row,
										"col" : col,
										"price" : 0,
										"color" : "",
										"thre_id" : options.thre_id, //�糡ID
										"hall_id" : options.hall_id, //��ID
										"movie_id" : options.hall_id, //��Ӱ����ID
									};
								} else {
									delete seats[key];
								}
								break;

							case 2:  //����Ʊ��
								if ($(this).hasSelected()) {
									seatColors[key] = 1;
								} else {
									delete seatColors[key];
								}
								console.log(seatColors);
								break;

							case 3: //��Ʊ
								var seat = {
									row : $(this).data("row"),
									col : $(this).data("col"),
									thre_id : $(this).data("thre_id"),
									hall_id : $(this).data("hall_id"),
									movie_id : $(this).data("movie_id"),
									price : $(this).data("price"),
								};
								//����ѡ���¼�
								if ($(this).hasSelected()) {
									if (ticketNumber >= options.maxTicketNumber) {
										$(this).unselectSeat(); //ѡ��ʧ��,״̬�ع�
										options.onerror("һ�����ѡ�� "+options.maxTicketNumber+" ����λ");
										return;
									} else {//ѡ���ɹ�
										options.selected[key] = 1;
										ticketNumber++;
										options.onSelected(seat);
									}
								} else {
									o.unselect(row, col);
									options.onUnselected(seat);
								}
								break;
						}
					}); //end onclick

					//����û����λ��λ��
					if (options.step != 1 && seats[sid] == undefined) {
						$seat.css({
							"border" : "none",
							"background" : "none"
						});
						$td.off("click"); //ж���¼�
					}

					//������ѡ����λ
					if (options.step ==3 && options.selected && options.selected[sid]) {
						$td.off("click"); //ж���¼�
						$seat.addClass("disabled");
					}

					$td.append($seat);
					$tr.append($td);

					//���������Ϊ����Ĭ��ѡ��ȫ����λ
					if (options.step ==1) {
						$td.trigger("click");
					}
				}
				$table.append($tr);
			}

			//���õ�Ӱ���Ŀ��
			$(options.box).css({
				width : (options.cols * (options.size + 1 + 4)) + "px"
			});
			$(options.box).append($table);
		}

		//��ȡ���е���λ��Ϣ
		o.getSeats = function() {
			return seats;
		}

		/**
		 * ���ü۸�
		 * @param price
		 * @param color
		 */
		o.setPrice = function(price, color) {
			if ( seatColors.length == 0 ) {
				return alert("��û��ѡ���κ���λ");
			}
			for (var key in seatColors) {
				seats[key].color = color;
				seats[key].price = price;
				//������λ�߿���ɫ
				$('#'+key).find("span").css({"border-color": color}).removeClass("selected");
			}
			seatColors = {}; //����������ϣ�ˢ�»���
		}

		//��ȡ��ѡ�����λ
		o.getSelectedSeats = function() {
			return options.selected;
		}

		//�ͷ�ĳ����λ
		o.unselect = function(row, col) {
			var key = row+"_"+col;
			delete options.selected[key];
			$("#"+key).unselectSeat();
			ticketNumber--;
		}

		//��ȡ����Ԫ�ظ���
		function getObjLength(o) {
			var c = 0;
			for (var k in o) {
				c++;
			}
			return c;
		}

		create();
		return o;
	}

	$.seats = function(options) {
		return new __seats__(options);
	};
})(jQuery);