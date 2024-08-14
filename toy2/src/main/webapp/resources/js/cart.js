$(document).ready(function() {
    // 모든 항목을 선택하거나 선택 해제하는 함수
    function CheckedAll() {
        const isChecked = $('#checkAll').is(':checked');
        $('.product-check').prop('checked', isChecked);
        updateSelectedInfo();  // 선택된 항목 수와 총 가격을 업데이트
    }

    // 선택된 항목 수와 총 가격을 업데이트하는 함수
    function updateSelectedInfo() {
        let selectedCount = 0;
        let selectedTotalPrice = 0;

        $('.product-check:checked').each(function() {
            const itemCount = parseInt($(this).data('count')); // 체크된 항목의 수량 가져오기
            selectedCount += itemCount;
            selectedTotalPrice += parseFloat($(this).data('price'));
        });

        $('.selectedCount').text(selectedCount);
        $('.selectedTotalPrice').text(selectedTotalPrice.toLocaleString('ko-KR'));

        // 개별 체크박스의 상태에 따라 전체 선택 체크박스 상태 설정
        const totalCheckboxes = $('.product-check').length;
        const checkedCheckboxes = $('.product-check:checked').length;
        $('#checkAll').prop('checked', totalCheckboxes === checkedCheckboxes);
    }

    // 삭제 기능 처리 (품절 상품 삭제, 선택 삭제)
    function deleteItems(isSoldOut) {
        let itemsToDelete;

        if (isSoldOut) {
            // 품절 상품 삭제
            itemsToDelete = $('.product-check').filter(function() {
                return $(this).data('salestate') === 'SC003';
            });
        } else {
            // 선택 삭제
            itemsToDelete = $('.product-check:checked');
        }

        if (itemsToDelete.length === 0) {
            alert(isSoldOut ? "품절 상품이 없습니다." : "선택된 상품이 없습니다.");
            return;
        }

        const items = itemsToDelete.map(function() {
            return {
                style_num: $(this).data('stylenum'),
                p_size: $(this).data('psize')
            };
        }).get();

        $.ajax({
            url: '/order/cart/removeItems',  // 삭제 요청을 처리할 URL
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(items),  // 서버로 보낼 데이터
            success: function(response) {
                // 성공적으로 삭제되면 화면에서 해당 항목들을 제거
                itemsToDelete.closest('li.product-item').remove();
                updateSelectedInfo(); // 정보 업데이트
            },
            error: function(error) {
                alert("삭제 중 오류가 발생했습니다.");
            }
        });
    }

    // 품절상품 삭제 버튼 클릭 시
    $('.delete__btn.soldout').on('click', function() {
        deleteItems(true);
    });

    // 선택 삭제 버튼 클릭 시
    $('.delete__btn.select').on('click', function() {
        deleteItems(false);
    });

    // 개별 체크박스가 클릭될 때 실행되는 이벤트 핸들러
    $(document).on('click', '.product-check', function() {
        updateSelectedInfo();
    });

    // "전체 선택" 체크박스가 클릭될 때 실행되는 이벤트 핸들러
    $('#checkAll').on('click', function() {
        CheckedAll();
    });

    // 초기 상태에서 선택된 항목 정보 업데이트
    updateSelectedInfo();
});