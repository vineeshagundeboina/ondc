function onclickFunction() {
    var checkstatus = false;
    var output = "<div class=\"container\">\n<ul class=\"row list-unstyled related_parties\">\n";
    $(document).ready(function () {

        var var1 = document.getElementById("application_form_application_enterprise_attributes_acc_no").value;
        $.ajax({
            type: "POST",
            url: "newappln",
            data: { "acctno": var1, "user": "new" },
            error: function () {
                alert("Something Went Wrong");
            },
            success: function (data) {
                var val = $.parseJSON(data);
                var code = val.statusCode;
                if (code == 01) {
                    alert_box("danger", val.status);
                }
                else {
                    var data = val.result.GetCustomerDetailsResp.AccountDetails;

                    $("#application_form_application_enterprise_attributes_acc_name").val(val.result.GetCustomerDetailsResp.AccountDetails.CUSTOMERNAME)
                    $("#application_form_application_enterprise_attributes_cust_no").val(val.result.GetCustomerDetailsResp.AccountDetails.CUSTOMERID)
                    $("#application_form_application_enterprise_attributes_branch").val(val.result.GetCustomerDetailsResp.AccountDetails.BRANCHCODE)
                    $("#application_form_application_enterprise_attributes_solid").val(val.result.GetCustomerDetailsResp.AccountDetails.SOLID)
                    $("#application_form_application_enterprise_attributes_address").html(val.result.GetCustomerDetailsResp.AccountDetails.ADDRESS1 + "\n" + val.result.GetCustomerDetailsResp.AccountDetails.ADDRESS2)
                    $("#application_form_application_enterprise_attributes_constitution").val(val.result.GetCustomerDetailsResp.AccountDetails.CONSTITUTION)

                    for (i = 0; i < data.RELATEDPARTY.DETAILS.length; i++) {

                        checkstatus = true;
                        var prefcop = Math.random().toString(36).substr(2, 6);


                        output += "<li class=\"col-md-6 user-form\">\n<div class=\"card bg-light border border-dark mb-3 text-left\">\n<div class=\"card-header bg-dark text-white font-weight-bold \">\n" + data.RELATEDPARTY.DETAILS[i].CUSTOMER_NAME + "\n  <\/div>\n <input type=\"hidden\"name=\"application_form[application_enterprise_attributes][application_users_attributes][][id]\"id=\"application_form_application_enterprise_attributes_application_users_attributes__id\" />\n<div class=\"card-body bg-secondary\">\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationUserName\" id=\"application_form_application_enterprise_attributes_application_users_attributes__user_name\" value=" + "'" + data.RELATEDPARTY.DETAILS[i].CUSTOMER_NAME + "'" + " placeholder=\"Name\" class=\"form-control form-control-sm\" minlength=\"3\" maxlength=\"100\" required=\"required\" readonly=\"readonly\" pattern=\"[a-zA-Z. ]+\" />\n<\/div><div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationPrefNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__pref_no\" value=" + prefcop + " placeholder=\"Preferred User ID\" pattern=\"^[a-zA-Z0-9]{2,20}$\" class=\"form-control form-control-sm\" required=\"required\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationCustNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__cust_no\" value=" + data.RELATEDPARTY.DETAILS[i].CUSTOMER_ID + " placeholder=\"Customer ID\" class=\"form-control form-control-sm readonly\" required=\"required\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationMobileNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__mobile\" value=" + data.RELATEDPARTY.DETAILS[i].CONTACT_NO + " placeholder=\"Mobile\" class=\"form-control form-control-sm\" required=\"required\" minlength=\"6\" maxlength=\"16\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationTransLimit\" id=\"trans_limit_0\" value=\"1000000\" placeholder=\"Transaction Limit\" class=\"form-control form-control-sm\" min=\"1\" max=\"1000000\" />\n <\/div>\n <div class=\"form-group row row-info\">\n Authorized Signatory : &nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"applicationAuthSignatory\" id=\"application_form_application_enterprise_attributes_application_users_attributes__authorized_signatory\"  />\n <\/div>\n <\/div>\n\n <div class=\"card-footer bg-secondary text-center\">\n <a class=\"close-icon btn btn-danger remove\" data-confirm=\"Are you sure?\" data-remote=\"true\" href=\"#\">Remove<\/a>\n <\/div>\n<\/li>\n ";
                    }

                    if (checkstatus == false) {

                        var prefcop = Math.random().toString(36).substr(2, 6);
                        output += "<li class=\"col-md-6 user-form\">\n<div class=\"card bg-light border border-dark mb-3 text-left\">\n<div class=\"card-header bg-dark text-white font-weight-bold \">\n" + data.RELATEDPARTY.DETAILS.CUSTOMER_NAME + "\n  <\/div>\n <input type=\"hidden\"name=\"id\"id=\"application_form_application_enterprise_attributes_application_users_attributes__id\" />\n<div class=\"card-body bg-secondary\">\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationUserName\" id=\"application_form_application_enterprise_attributes_application_users_attributes__user_name\" value=" + "'" + data.RELATEDPARTY.DETAILS.CUSTOMER_NAME + "'" + " placeholder=\"Name\" class=\"form-control form-control-sm\" minlength=\"3\" maxlength=\"100\" required=\"required\" readonly=\"readonly\" pattern=\"[a-zA-Z]+\" />\n<\/div><div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationPrefNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__pref_no\" value=" + prefcop + " placeholder=\"Preferred User ID\" pattern=\"^[a-zA-Z0-9]{2,20}$\" class=\"form-control form-control-sm\" required=\"required\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationCustNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__cust_no\" value=" + data.RELATEDPARTY.DETAILS.CUSTOMER_ID + " placeholder=\"Customer ID\" class=\"form-control form-control-sm readonly\" required=\"required\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationMobileNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__mobile\" value=" + data.RELATEDPARTY.DETAILS.CONTACT_NO + " placeholder=\"Mobile\" class=\"form-control form-control-sm\" required=\"required\" minlength=\"6\" maxlength=\"16\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationTransLimit\" id=\"trans_limit_0\" value=\"1000000\" placeholder=\"Transaction Limit\" class=\"form-control form-control-sm\" min=\"1\" max=\"1000000\" />\n <\/div>\n <div class=\"form-group row row-info\">\n Authorized Signatory : &nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"applicationAuthSignatory\" id=\"application_form_application_enterprise_attributes_application_users_attributes__authorized_signatory\" value=\"true\" />\n <\/div>\n <\/div>\n\n <div class=\"card-footer bg-secondary text-center\">\n<\/div>\n<\/li>\n ";

                    }


                    output += "<\/ul>\n<\/div>\n<p class=\"text-center\"><a  id=\"auto_load_users\" class=\"btn btn-info auto_load_users\" href=\"javascript:void(0)\" onclick=\"return onclickFunction()\">Add User<\/a><\/p>\n";
                    $(".users_form").html(output);
                    $('.readonly').prop("readonly", true);

                    if (i == 0) {
                        $('.user_auth').prop('max', 0)
                        if ($("#singleOrMultipleOptions").prop("readonly")) {
                            $("#singleOrMultipleOptions")
                                .empty()
                                .append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');
                        }
                        $("#singleOrMultipleOptions").prop('readonly', false);
                        $("#firstCheckBox").html("Board Resolution/Letter of Mandate Obtained and Verified");
                        $("#secondCheckBox").html("Mode of Operation and rules for Account operation details confirmed");
                        $("#singleOrMultipleOptions").prop('readonly', true);
                        $("#singleOrMultipleOptions")
                            .empty()
                            .append('<option selected="selected" value="Single">Single</option>)');
                        $("#disableRulesForAccountOperation1").prop('readonly', true);
                        $("#disableRulesForAccountOperation1").val("0");
                        $("#disableRulesForAccountOperation2").prop('readonly', true);
                        $("#disableRulesForAccountOperation2").val("0");
                        $("#disableRulesForAccountOperation3").prop('readonly', true);
                        $("#disableRulesForAccountOperation3").val("0");

                        $("#singleOrMultipleOptions").html('<option selected="selected" value="Single">Single</option>');

                    }

                    else {
                        $('.user_auth').prop('max', 1)
                        if ($("#singleOrMultipleOptions").prop("readonly")) {
                            $("#singleOrMultipleOptions")
                                .empty()
                                .append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');
                        }
                        $("#singleOrMultipleOptions").prop('readonly', false);
                        $("#firstCheckBox").html("Board Resolution/Letter of Mandate Obtained and Verified");
                        $("#secondCheckBox").html("Mode of Operation and rules for Account operation details confirmed");
                        if ($("#singleOrMultipleOptions").prop("readonly")) {
                            $("#singleOrMultipleOptions")
                                .empty()
                                .append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');
                        }
                        $("#singleOrMultipleOptions").prop('readonly', false);
                        $("#disableRulesForAccountOperation1").prop('readonly', false);
                        $("#disableRulesForAccountOperation1").val("1");
                        $("#disableRulesForAccountOperation2").prop('readonly', false);
                        $("#disableRulesForAccountOperation2").val("1");
                        $("#disableRulesForAccountOperation3").prop('readonly', false);
                        $("#disableRulesForAccountOperation3").val("1");

                        $("#disableRulesForAccountOperation1").attr({
                            "max": i - 1,
                            "min": 1
                        });
                        $("#disableRulesForAccountOperation2").attr({
                            "max": i - 1,
                            "min": 1
                        });
                        $("#disableRulesForAccountOperation3").attr({
                            "max": i - 1,
                            "min": 1
                        });

                        $("#singleOrMultipleOptions").html('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');


                    }

                }

            }
        });
    });

}



function onclickUserFunction() {
    var checkstatus = false;
    var output = "<div class=\"container\">\n<ul class=\"row list-unstyled related_parties\">\n";
    $(document).ready(function () {
        var var1 = document.getElementById("application_form_application_enterprise_attributes_acc_no").value;
        $.ajax({
            type: "POST",
            url: "newappln",
            data: { "acctno": var1, "user": "Exist" },
            error: function () {
                alert("Error Occured");
            },
            success: function (data) {
                var val = $.parseJSON(data);
                var code = val.statusCode;
                if (code == 01) {
                    alert_box("danger", val.status);
                }
                else {

                    var data = val.result.GetCustomerDetailsResp.AccountDetails;


                    for (i = 0; i < data.RELATEDPARTY.DETAILS.length; i++) {

                        checkstatus = true;
                        var prefcop = Math.random().toString(36).substr(2, 4);
                        output += "<li class=\"col-md-6 user-form\">\n<div class=\"card bg-light border border-dark mb-3 text-left\">\n<div class=\"card-header bg-dark text-white font-weight-bold \">\n" + data.RELATEDPARTY.DETAILS[i].CUSTOMER_NAME + "\n  <\/div>\n <input type=\"hidden\"name=\"id\"id=\"application_form_application_enterprise_attributes_application_users_attributes__id\" />\n<div class=\"card-body bg-secondary\">\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationUserName\" id=\"application_form_application_enterprise_attributes_application_users_attributes__user_name\" value='" + data.RELATEDPARTY.DETAILS[i].CUSTOMER_NAME + "' placeholder=\"Name\" class=\"form-control form-control-sm\" minlength=\"3\" maxlength=\"100\" required=\"required\" readonly=\"readonly\" pattern=\"[a-zA-Z. ]+\" />\n<\/div><div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationPrefNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__pref_no\" value=" + prefcop + " placeholder=\"Preferred User ID\" pattern=\"^[a-zA-Z0-9]{2,20}$\" class=\"form-control form-control-sm\" required=\"required\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationCustNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__cust_no\" value=" + data.RELATEDPARTY.DETAILS[i].CUSTOMER_ID + " placeholder=\"Customer ID\" class=\"form-control form-control-sm readonly\" required=\"required\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationMobileNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__mobile\" value=" + data.RELATEDPARTY.DETAILS[i].CONTACT_NO + " placeholder=\"Mobile\" class=\"form-control form-control-sm\" required=\"required\" minlength=\"6\" maxlength=\"16\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationTransLimit\" id=\"trans_limit_0\" value=\"1000000\" placeholder=\"Transaction Limit\" class=\"form-control form-control-sm\" min=\"1\" max=\"1000000\" />\n <\/div>\n <div class=\"form-group row row-info\">\n Authorized Signatory : &nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"applicationAuthSignatory\" id=\"application_form_application_enterprise_attributes_application_users_attributes__authorized_signatory\"  />\n <\/div>\n <\/div>\n\n <div class=\"card-footer bg-secondary text-center\">\n <a id=\"someid\" class=\"close-icon btn btn-danger remove\" onclick=\"return removeUser(this);\"  href=\"javascript:void(0)\">Remove<\/a>\n <\/div>\n<\/li>\n ";
                    }

                    if (checkstatus == false) {
                        var prefcop = Math.random().toString(36).substr(2, 4);
                        output += "<li class=\"col-md-6 user-form\">\n<div class=\"card bg-light border border-dark mb-3 text-left\">\n<div class=\"card-header bg-dark text-white font-weight-bold \">\n" + data.RELATEDPARTY.DETAILS.CUSTOMER_NAME + "\n  <\/div>\n <input type=\"hidden\"name=\"id\"id=\"application_form_application_enterprise_attributes_application_users_attributes__id\" />\n<div class=\"card-body bg-secondary\">\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationUserName\" id=\"application_form_application_enterprise_attributes_application_users_attributes__user_name\" value='" + data.RELATEDPARTY.DETAILS.CUSTOMER_NAME + "' placeholder=\"Name\" class=\"form-control form-control-sm\" minlength=\"3\" maxlength=\"100\" required=\"required\" readonly=\"readonly\" pattern=\"[a-zA-Z. ]+\" />\n<\/div><div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationPrefNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__pref_no\" value=" + prefcop + " placeholder=\"Preferred User ID\" pattern=\"^[a-zA-Z0-9]{2,20}$\" class=\"form-control form-control-sm\" required=\"required\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"text\" name=\"ApplicationCustNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__cust_no\" value=" + data.RELATEDPARTY.DETAILS.CUSTOMER_ID + " placeholder=\"Customer ID\" class=\"form-control form-control-sm readonly\" required=\"required\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationMobileNo\" id=\"application_form_application_enterprise_attributes_application_users_attributes__mobile\" value=" + data.RELATEDPARTY.DETAILS.CONTACT_NO + " placeholder=\"Mobile\" class=\"form-control form-control-sm\" required=\"required\" minlength=\"6\" maxlength=\"16\" readonly=\"readonly\" />\n <\/div>\n <div class=\"form-group row row-info\">\n <input type=\"number\" name=\"applicationTransLimit\" id=\"trans_limit_0\" value=\"1000000\" placeholder=\"Transaction Limit\" class=\"form-control form-control-sm\" min=\"1\" max=\"1000000\" />\n <\/div>\n <div class=\"form-group row row-info\">\n Authorized Signatory : &nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"applicationAuthSignatory\" id=\"application_form_application_enterprise_attributes_application_users_attributes__authorized_signatory\"  />\n <\/div>\n <\/div>\n\n <div class=\"card-footer bg-secondary text-center\">\n<\/div>\n<\/li>\n ";
                    }
                    output += "<\/ul>\n<\/div>\n<p class=\"text-center\"><\/p>\n";
                    $(".related_parties").html(output);
                    $('.readonly').prop("readonly", true);
                    if (i == 0) {
                        $('.user_auth').prop('max', 0)
                        if ($("#singleOrMultipleOptions").prop("readonly")) {
                            $("#singleOrMultipleOptions")
                                .empty()
                                .append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');
                        }
                        $("#singleOrMultipleOptions").prop('readonly', false);
                        $("#firstCheckBox").html("Board Resolution/Letter of Mandate Obtained and Verified");
                        $("#secondCheckBox").html("Mode of Operation and rules for Account operation details confirmed");
                        $("#singleOrMultipleOptions").prop('readonly', true);
                        $("#singleOrMultipleOptions")
                            .empty()
                            .append('<option selected="selected" value="Single">Single</option>)');
                        $("#disableRulesForAccountOperation1").prop('readonly', true);
                        $("#disableRulesForAccountOperation1").val("0");
                        $("#disableRulesForAccountOperation2").prop('readonly', true);
                        $("#disableRulesForAccountOperation2").val("0");
                        $("#disableRulesForAccountOperation3").prop('readonly', true);
                        $("#disableRulesForAccountOperation3").val("0");
                    }

                    else {
                        $('.user_auth').prop('max', 1)
                        if ($("#singleOrMultipleOptions").prop("readonly")) {
                            $("#singleOrMultipleOptions")
                                .empty()
                                .append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');
                        }
                        $("#singleOrMultipleOptions").prop('readonly', false);
                        $("#firstCheckBox").html("Board Resolution/Letter of Mandate Obtained and Verified");
                        $("#secondCheckBox").html("Mode of Operation and rules for Account operation details confirmed");
                        if ($("#singleOrMultipleOptions").prop("readonly")) {
                            $("#singleOrMultipleOptions")
                                .empty()
                                .append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');
                        }
                        $("#singleOrMultipleOptions").prop('readonly', false);
                        $("#disableRulesForAccountOperation1").prop('readonly', false);
                        $("#disableRulesForAccountOperation1").val("1");
                        $("#disableRulesForAccountOperation2").prop('readonly', false);
                        $("#disableRulesForAccountOperation2").val("1");
                        $("#disableRulesForAccountOperation3").prop('readonly', false);
                        $("#disableRulesForAccountOperation3").val("1");

                        $("#disableRulesForAccountOperation1").attr({
                            "max": i - 1,
                            "min": 1
                        });
                        $("#disableRulesForAccountOperation2").attr({
                            "max": i - 1,
                            "min": 1
                        });
                        $("#disableRulesForAccountOperation3").attr({
                            "max": i - 1,
                            "min": 1
                        });
                        $("#singleOrMultipleOptions").html('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</option>');

                    }



                }

            }
        });
    });
}

function blockSpecialChar(e) {
    var k;
    document.all ? k = e.keyCode : k = e.which;
    return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57));
}

function nospaces(t) {
    if (t.value.match(/\s/g)) {
        t.value = t.value.replace(/\s/g, '');
    }
}

function onclickRemoveUser(var11, var12, event) {

    if (confirm("Are you sure to remove user?")) {
        res = true;
        if (res) {
            $.ajax({
                type: "POST",
                url: "removenewappln",
                data: { "authuserid": var11, "userperfid": var12 },
                error: function () {
                    alert("Error Occured");
                },
                success: function (data) {
                }
            });

            var t, e, n, i;
            return n = $(event).closest(".user-form"),
                i = n.find("#application_form_application_enterprise_attributes_application_users_attributes__id").val(), /^\s*$/.test(i) || (t = $("#application_form_application_enterprise_attributes_id").val()), e = $(".user-form").length, window.originalLength = $(".user-form").length, 2 === e ? ($(".remove").hide(), void n.slideUp(function () {
                    var t;
                    return $(event).remove(),
                        t = $(".user-form").length, $(".user_auth").prop("max", t - 1),
                        $("#singleOrMultipleOptions").prop("readonly", !0), $("#singleOrMultipleOptions").empty().append('<option selected="selected" value="Single">Single</options)'), $("#disableRulesForAccountOperation1").prop("readonly", !0), $("#disableRulesForAccountOperation1").val("0"), $("#disableRulesForAccountOperation2").prop("readonly", !0), $("#disableRulesForAccountOperation2").val("0"), $("#disableRulesForAccountOperation3").prop("readonly", !0), $("#disableRulesForAccountOperation1").prop("min", 0), $("#disableRulesForAccountOperation2").prop("min", 0), $("#disableRulesForAccountOperation3").prop("min", 0), $("#disableRulesForAccountOperation3").val("0")
                })) : n.slideUp(function () {
                    var t;
                    $(event).remove(), t = $(".user-form").length, $(".user_auth").prop("max", t - 1), $("#singleOrMultipleOptions").prop("readonly") && $("#singleOrMultipleOptions").empty().append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</options>'), $("#singleOrMultipleOptions").prop("readonly", !1), $("#disableRulesForAccountOperation1").prop("readonly", !1), $("#disableRulesForAccountOperation2").prop("readonly", !1), $("#disableRulesForAccountOperation3").prop("readonly", !1)
                })
        } else {
            console.log("Cancel confirmation: " + res);
            return false;
        }
    }
}


function removeUser(event) {
    var res = false;
    if (confirm("Are you sure to remove user?")) {
        res = true;
        if (res) {
            var t, e, n, i;
            return n = $(event).closest(".user-form"),
                i = n.find("#application_form_application_enterprise_attributes_application_users_attributes__id").val(), /^\s*$/.test(i) || (t = $("#application_form_application_enterprise_attributes_id").val()), e = $(".user-form").length, window.originalLength = $(".user-form").length, 2 === e ? ($(".remove").hide(), void n.slideUp(function () {
                    var t;
                    return $(event).remove(),
                        t = $(".user-form").length, $(".user_auth").prop("max", t - 1),
                        $("#singleOrMultipleOptions").prop("readonly", !0), $("#singleOrMultipleOptions").empty().append('<option selected="selected" value="Single">Single</options)'), $("#disableRulesForAccountOperation1").prop("readonly", !0), $("#disableRulesForAccountOperation1").val("0"), $("#disableRulesForAccountOperation2").prop("readonly", !0), $("#disableRulesForAccountOperation2").val("0"), $("#disableRulesForAccountOperation3").prop("readonly", !0), $("#disableRulesForAccountOperation1").prop("min", 0), $("#disableRulesForAccountOperation2").prop("min", 0), $("#disableRulesForAccountOperation3").prop("min", 0), $("#disableRulesForAccountOperation3").val("0")
                })) : n.slideUp(function () {
                    var t;
                    $(event).remove(), t = $(".user-form").length, $(".user_auth").prop("max", t - 1), $("#singleOrMultipleOptions").prop("readonly") && $("#singleOrMultipleOptions").empty().append('<option value="Joint">Joint</option> <option value="E or S">E or S</option> <option value="A or S">A or S</options>'), $("#singleOrMultipleOptions").prop("readonly", !1), $("#disableRulesForAccountOperation1").prop("readonly", !1), $("#disableRulesForAccountOperation2").prop("readonly", !1), $("#disableRulesForAccountOperation3").prop("readonly", !1)
                });
        } else {
            console.log("Cancel confirmation: " + res);
            return false;
        }

    }
}

function rejectappln(id) {
    if (confirm("Are you sure?")) {
        if (id) {
            $.ajax({
                type: 'POST',
                url: 'rejectappln',
                data: 'appid=' + id,
                success: function (html) {
                    $('.modal-data').html(html);

                }
            });
        } else {
            $('.modal-data').html('');
        }

    }

}




function updateClick() {
    var acc_no = $('#acc_no').val();
    var cust_id = $('#cust_no').val();
    var mobile = $('#mobile_no').val();
    console.log(acc_no);
    console.log(cust_id);
    //   thisdata = $(this).attr('data-whatever');
    $.ajax({
        type: 'POST',
        url: 'updatemobile',
        data: { "action": "mobileupdate", "account": acc_no, "cust": cust_id, "mobile": mobile },
        success: function (data) {
			console.log(data);

            //  window.location.reload();
            var val = $.parseJSON(data);
            if (val.status) {
                const result = window.confirm(val.message);
                console.log(result);

                if (result) {
                    updateMobileNumber(val);
                }
            } else {
                alert_box("danger", val.message);
            }
        }
    });


};

function updateMobileNumber(val) {

    var cust_id = $('#cust_no').val();
    var addedBy = $('#addedBy').val();
    $.ajax({
        type: 'POST',
        url: 'newappln',
        data: { "action": "mobileupdate", "type": "update", "oldMobile": val.oldMobile, "newMobile": val.getCustMobile, "cust": cust_id, "addedBy": addedBy },
        success: function (data) {
            var val = $.parseJSON(data);
            console.log(val);
            if (val.status) {
                alert_box("success", "Mobile number updated successfully");
                window.setTimeout(setTimeOut, 7000);
            } else {
                alert_box("danger", "Something went wrong, while updating mobile number");
            }
        }
    });
}

function setTimeOut() {
    window.location.reload();
}

function authSignUpdate(event, pref) {
    var hiddenValue = document.getElementById(pref).value;
    var mainInput = document.getElementById("application_form_application_enterprise_attributes_application_users_attributes__authorized_signatory")
    if (event.currentTarget.checked) {
        document.getElementById(pref).value = 'true';
    } else {
        document.getElementById(pref).value = 'false';
    }
}


function authSignUpdateDynamic(pref) {
    debugger;
    var hiddenValue = document.getElementById(pref.id).value;
    var mainInput = document.getElementById("application_form_application_enterprise_attributes_application_users_attributes__authorized_signatory")
    if (pref.checked) {
        document.getElementById(pref.id).value = 'true';
    } else {
        document.getElementById(pref.id).value = 'false';
    }
}



if (window.history.replaceState) {
    window.history.replaceState(null, null, window.location.href);
}