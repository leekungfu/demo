$(document).ready(function () {

    $.validator.addMethod(
        "emailValidate",
        function (value, element, params) {
            const regex = new RegExp("^\\w*@\\w{5}\\.\\w{3}");

            return regex.test(value) === params;
        },
        "Email is invalid. Please enter your correct email"
    );

    $.validator.addMethod(
        "phoneValidate",
        function (value, element, params) {
            const regex = new RegExp("^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4}$");

            return regex.test(value) === params;
        },
        "Phone number is invalid. Please enter your correct phone number"
    );

    $("#editForm").validate({
        rules: {
            email: {
                required: true,
                emailValidate: true,
                maxlength: 50,
            },

            firstName: {
                required: true,
                minlength: 3,
                maxlength: 50,
            },

            lastName: {
                required: true,
                minlength: 3,
                maxlength: 50,
            },
            phone: {
                required: true,
                phoneValidate: true,
            }

        },
        messages: {
            email: {
                maxlength: "Email is not exceed 50 characters",
            },

            firstName: {
                required: "Please enter your first name",
                maxlength: "First name is not exceed 50 characters",
            },

            lastName: {
                required: "Please enter your last name",
                maxlength: "Last name is not exceed 50 characters",
            },

            phone: {},
        },
    });

    // $(document).on("click", "#editbtnSubmit", function () {
    //     if ($("#editForm").valid()) {
    //         $.ajax({
    //             method: "GET",
    //             url: "/home",
    //             success: function (res) {
    //                 $(".main-content").html(res);
    //             },
    //             error: function (err) {
    //                 console.log(err);
    //             },
    //         });
    //     }
    // });

});