$(document).ready(function () {

    $("#addForm").validate({
        rules: {
            title: {
                required: true,
                minlength: 3,
                maxlength: 50,
            },
        },
        messages: {
            title: {
                required: " Please enter the title",
                minlength: "Title is at least 3 characters",
                maxlength: "Title is not exceed 50 characters",
            },
        },
    });

    $(document).on("click", "#addbtnSubmit", function () {
        if ($("#addForm").valid()) {
            $.ajax({
                method: "GET",
                url: "./add_content",
                success: function (res) {
                    $(".main-content").html(res);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        }
    });
});