$(function () {


    // initiate the debit command
    $("#debit-btn").on("click", function () {
        var accountToDebit = $("#debit-account-no").val();
        if (accountToDebit === "null" || accountToDebit === undefined) {
            alert("Choose Account to debit");
            return;
        }
        var amount = $("#debit-amount").val();
        if (!amount || amount === 0) {
            alert("Specify amount to debit");
            return;
        }

        $.ajax({
            url: "/debit",
            method: "GET",
            data: {"acc": accountToDebit, "amount": amount},
            success: function (a) {
                $("#debit-amount").val("");
            },
            error: function (a) {
                console.log(a);
            }
        })
    });

    $("#save_patient_btn").on("click", function () {
        var patient_id = $("#patient_id").val();
        if (patient_id === "null" || patient_id === undefined) {
            alert("patientID can't be null.");
            return;
        }
        var patient_name_chinese = $("#patient_name_chinese").val();
        var patient_name_english = $("#patient_name_english").val();
        var gender = $("#gender").val();
        var birthday = $("#birthday").val();
        var id_card = $("#id_card").val();
        var phone_number = $("#phone_number").val();
        var address = $("#address").val();
        var allergy_history = $("#allergy_history").val();

        $.ajax({
            url: "/patient/save",
            method: "GET",
            data: {
                "patId": patient_id,
                "patNameChinese": patient_name_chinese,
                "patNameEnglish": patient_name_english,
                "gender": gender,
                "birthday": birthday,
                "idCard": id_card,
                "phone": phone_number,
                "address": address,
                "allergy": allergy_history
            },
            success: function (msg) {
                alert(msg);
            },
            error: function (a) {
                console.log(a);
            }
        })
    });


    // initiate the credit command
    $("#credit-btn").on("click", function () {
        var accountToCredit = $("#credit-account-no").val();
        if (accountToCredit === "null" || accountToCredit === undefined) {
            alert("Choose Account to credit");
            return;
        }
        var amount = $("#credit-amount").val();
        if (!amount || amount === 0) {
            alert("Specify amount to credit");
            return;
        }

        $.ajax({
            url: "/credit",
            method: "GET",
            data: {"acc": accountToCredit, "amount": amount},
            success: function (a) {
                $("#credit-amount").val("");
            },
            error: function (a) {
                console.log(a);
            }
        });
    });



/*
    // queries for the view
    setInterval(function () {

        $.ajax({
            url: "/view",
            method: "GET",
            success: function (accounts) {
                var html = "";
                accounts.forEach(function (account) {
                    for (var key in account) {
                        html += "<tr><td>" + key + "</td><td>" + account[key] + "</td></tr>"
                    }
                });
                $("table#balance tbody").html(html);
            },
            error: function (a) {
                console.log(a);
            }
        });

    }, 8000);*/


});

function selectPatient(patientID) {
    $.ajax({
        url: "/patient/find",
        method: "GET",
        data: {"patId": patientID},
        success: function (data) {
            $("#patient_id").val(data.patientId);
            $("#patient_name_chinese").val(data.patientNameChinese);
            $("#patient_name_english").val(data.patientNameEnglish);
            $("#gender").val(data.gender);
            $("#birthday").val(data.birthday);
            $("#id_card").val(data.idCard);
            $("#phone_number").val(data.phoneNumber);
            $("#address").val(data.address);
            $("#allergy_history").val(data.allergyHistory);
        },
        error: function (a) {
            console.log(a);
        }
    });
}