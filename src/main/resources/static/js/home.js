$(document).ready(function () {
    // $(document).on("click", "#view-content", function () {
    //     $.ajax({
    //         method: "GET",
    //         url: "./view",
    //         success: function (res) {
    //             $(".main-content").html(res);
    //         },
    //         error: function (err) {
    //             console.log("ERROR");
    //             console.log(err);
    //         },
    //     });
    // });

    $(document).on("click", "#add-content", function () {
        $.ajax({
            method: "GET",
            url: "./add_content",
            success: function (res) {
                $(".main-content").html(res);
            },
            error: function (err) {
                console.log("ERROR");
                console.log(err);
            },
        });
    });

    $(document).on("click", "#user-profile", function () {
        $.ajax({
            method: "GET",
            url: "./edit_profile",
            success: function (res) {
                $(".main-content").html(res);
            },
            error: function (err) {
                console.log("ERROR");
                console.log(err);
            },
        });
    });

    $(document).on("click", "#view-content", function () {
        $.ajax({
            method: "GET",
            url: "./view_content",
            success: function (res) {
                $(".main-content").html(res);
            },
            error: function (err) {
                console.log("ERROR");
                console.log(err);
            },
        });
    });

    $(document).on("click", "#delete-content", function () {
        $.ajax({
            method: "GET",
            url: "./delete",
            success: function (res) {
                $(".main-content").html(res);
            },
            error: function (err) {
                console.log("ERROR");
                console.log(err);
            },
        });
    });
});

