$(function(){
    $(".new-link-btn").click(function(){
        $(".new-modal").fadeIn();
    });

    $(".update-link-btn").click(function(){
        var id = $(this).attr("data-id");
        var url = `/update/${id}`;
        var purchaseDate = $(this).attr("data-purchase-date");
        var itemName = $(this).attr("data-item-name");
        var price = $(this).attr("data-price");

        $(".update-modal").fadeIn();
        $(".update-submit-form").attr("action", url);
        $(".purchaseDate").val(purchaseDate);
        $(".itemName").val(itemName);
        $(".price").val(price);
    });

    $(".delete-link-btn").click(function(){
        var id = $(this).attr("data-id");
        var url = `/delete/${id}`;
        var purchaseDate = $(this).attr("data-purchase-date");
        var itemName = $(this).attr("data-item-name");
        var price = $(this).attr("data-price");

        $(".delete-modal").fadeIn();
        $(".delete-submit-form").attr("action", url);
        $(".delete-table-purchase-date").text(purchaseDate);
        $(".delete-table-item-name").text(itemName);
        $(".delete-table-price").text(price);
    });

    $(".cancel-btn").click(function(){
        $(".new-modal").fadeOut();
        $(".update-modal").fadeOut();
        $(".delete-modal").fadeOut();
    });

});