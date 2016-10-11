$(function () {
    // initiate the debit command
    $("#debit-btn").on("click", function () {
        var accountToDebit = $("#debit-account-no").val();
        if (accountToDebit == "null" || accountToDebit == undefined) {
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
                var newTR = "<td>" + patient_id + "</td>" + "<td>" + patient_name_chinese + "</td>" +
                    "<td>" + patient_name_english + "</td>" + "<td>" + gender + "</td>" +
                    "<td>" + birthday + "</td>" + "<td>" + id_card + "</td>" + "<td>" + phone_number + "</td>" +
                    "<td>" + address + "</td>" + "<td>" + allergy_history + "</td>";
                if($("#" + patient_id).length > 0) {
                    $("#" + patient_id).html(newTR);
                } else {
                    $("#patient-table tbody").prepend("<tr id='" + patient_id + "'>" + newTR + "</tr>");
                }
            },
            error: function (a) {
                console.log(a);
            }
        })
    });

// initiate the credit command
    $("#schedule-btn").on("click", function () {
        var patient_id = $("#patient_id").val();
        if (patient_id == "null" || patient_id == undefined || patient_id == '') {
            alert("patientID can't be null.");
            return;
        }
        var patient_name_chinese = $("#patient_name_chinese").val();
        var diagnose = $("#diagnose").val();
        var body_part = $("#body_part").val();
        var schedule_time = $("#schedule_time").val();
        var terminal = $("#terminal").val();
        var course = $("#course").val();

        $.ajax({
            url: "/patient/schedule",
            method: "GET",
            data: {
                "patId": patient_id,
                "diagnose": diagnose,
                "body_part": body_part,
                "schedule_time": schedule_time,
                "terminal": terminal,
                "course": course
            },
            success: function (msg) {
                var newTR = "<tr><td>"+patient_id+"</td><td>"+patient_name_chinese+"</td>"+
                    "<td>" + diagnose + "</td>" + "<td>" + body_part + "</td>" +
                    "<td>" + schedule_time + "</td>" + "<td>" + terminal + "</td>" +
                    "<td>" + course + "</td></tr>";
                if($("#" + patient_id).length > 0) {
                    $("#schedule-table tbody").prepend(newTR);
                }
            },
            error: function (a) {
                console.log(a);
            }
        })
    });

    $("#patient-table tbody tr").click(function(){
        var patientID = $(this).attr("id");
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

                $("#schedule-table tbody tr").remove();
                $.each(data.scheduleList, function (n, schedule) {
                    var newTR = "<tr><td>"+data.patientId+"</td>"+"<td>"+data.patientNameChinese+"</td>" +
                        "<td>" + schedule.diagnose + "</td>" + "<td>" + schedule.bodyPart + "</td>" +
                        "<td>" + schedule.scheduleTime + "</td>" + "<td>" + schedule.terminal + "</td>" +
                        "<td>" + schedule.course + "</td></tr>";
                    $("#schedule-table tbody").append(newTR);
                })
            },
            error: function (a) {
                console.log(a);
            }
        });
    });
});
