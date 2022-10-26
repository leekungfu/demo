$(document).ready(function () {

    $.validator.addMethod(
        "emailValidate",
        function (value, element, params) {
            const regex = new RegExp("^\\w*@\\w{5}\\.\\w{3}");

            return regex.test(value) === params;
        },
        "Email is invalid. Please enter your correct email"
    );

    $("#registerForm").validate({
        rules: {
            email: {
                required: true,
                emailValidate: true,
            },
            username: {
                required: true,
                minlength: 3,
                maxlength: 50,
            },
            password: {
                required: true,
                minlength: 3,
                maxlength: 50,
            },
            repassword: {
                required: true,
                minlength: 3,
                maxlength: 50,
                equalTo: "#password",
            },

        },
        messages: {
            username: {
                required: "Please input your user name",
                minlength: "User name is at least 3 characters",
                maxlength: "User name can not be over 50 characters",
            },
            email: {},
            password: {
                required: "Please input your password",
                minlength: "At least 3 characters",
                maxlength: "Not exceed 50 characters",
            },
            repassword: {
                required: "Please enter your password again",
                minlength: "At least 3 characters",
                maxlength: "Not exceed 50 characters",
                equalTo: "Password doesn't match!",
            },

        },
    });
});
