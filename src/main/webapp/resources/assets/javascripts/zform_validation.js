$(function() {
  $(":input").inputmask()
});

$(document).on('turbolinks:load', function() {
  $("#needs-validation").validate({
    rules: {
      'application_form[application_enterprise_attributes][acc_no]': {
        digits: true,
        minlength: 14,
        maxlength: 14
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][pref_no]': {
        required: true,
        regex: /^[a-zA-Z0-9]{2,20}$/,
        minlength: 3,
        maxlength: 20
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][mobile]': {
        // regex: /^(91)[789]\d{9}$/,
        required: true
      },
      'application_form[application_enterprise_attributes][monthly_limit]': {
        greaterThan: "#application_form_application_enterprise_attributes_daily_limit",
        minlength: 3,
        maxlength: 9
      },
      'application_form[application_enterprise_attributes][daily_limit]': {
        lesserThan: "#application_form_application_enterprise_attributes_monthly_limit",
        minlength: 3,
        maxlength: 7
      },
      // 'application_form[application_enterprise_attributes][application_users_attributes][][trans_limit]': {
      'application_form[application_user][trans_limit]': {
        required: true,
        lesserThan: "#application_form_application_enterprise_attributes_daily_limit",
        minlength: 3,
        maxlength: 7
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][authorized_signatory]': {
        required: true
      },
    },
    messages: {
      'application_form[application_enterprise_attributes][acc_no]': {
        required: 'Account No. cannot be blank. Please provide valid 14 digit Account No.',
        minlength: 'Please provide valid 14 digit Account No.',
        maxlength: 'Please provide valid 14 digit Account No.'
      },
      'application_form[application_enterprise_attributes][acc_name]': {
        required: 'Please provide a valid Account Name.'
      },
      'application_form[application_enterprise_attributes][cust_no]': {
        required: 'Please provide a valid Customer ID.'
      },
      'application_form[application_enterprise_attributes][branch]': {
        required: 'Please provide a valid Branch.'
      },
      'application_form[application_enterprise_attributes][address]': {
        required: 'Please provide a valid Preferred Address.'
      },
      'application_form[application_enterprise_attributes][constitution]': {
        required: 'Please provide a valid Constitution.'
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][user_name]': {
        required: 'Please provide a valid User Name.'
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][pref_no]': {
        required: 'Please provide a valid Preferred User ID.',
        regex: 'Should only contain alphanumeric charachers.',
        minlength: 'Preferred User ID should be between 3 and 20 alphanumeric characters long.',
        maxlength: 'Preferred User ID should be between 3 and 20 alphanumeric characters long.'
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][cust_no]': {
        required: 'Please provide a valid  Customer ID.'
      },
      'application_form[application_user][trans_limit]': {
        lesserThan: 'Transaction limit must be lesser than daily limit.'
      },
      'application_form[application_enterprise_attributes][pref_corp]': {
        required: 'Please provide a valid Preferred Corporate ID.',
        minlength: 'Preferred Corporate ID should be between 3 and 20 alphanumeric characters long.',
        maxlength: 'Preferred Corporate ID should be between 3 and 20 alphanumeric characters long.'
      },
      'application_form[application_enterprise_attributes][auth_fund]': {
        required: 'Please provide No of authorizers required for fund transfer'
      },
      'application_form[application_enterprise_attributes][auth_ext]': {
        required: 'Please provide No of authorizers required for external user addition'
      },
      'application_form[application_enterprise_attributes][auth_ben]': {
        required: 'Please provide No of authorizers required for beneficiary addition'
      },
      'application_form[document_attributes][document]': {
        required: 'Please select a pdf file.'
      },
      'application_form[application_enterprise_attributes][daily_limit]': {
        required: 'Please provide a valid Daily Limit.',
        lesserThan: "Daily limit must be less than Monthly limit"
      },
      'application_form[application_enterprise_attributes][monthly_limit]': {
        required: 'Please provide a valid Monthly Limit.',
        greaterThan: "Monthly limit must be greater than Daily limit"
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][mobile]': {
        required: 'Cannot proceed without mobile no.',
        // regex: 'Invalid mobile no.1',
        minlength: 'Please check the mobile number',
        maxlength: 'Please check the mobile number'
      },
      'application_form[document_attributes][document]': {
        required: 'Please select a pdf file'
      },
      'application_form[application_enterprise_attributes][application_users_attributes][][authorized_signatory]': {
        required: "You must select at least 1 Authorized Signatory to proceed."
      }

    },
    errorPlacement: function(error, element) {
      console.log(element.attr("type"));
      if (element.attr("type") === "checkbox") {
        error.insertAfter(element.parent());
      } else {
        error.insertAfter(element);
      }
    }
  });
});

$.validator.addMethod("greaterThan",
  function(value, element, param) {
    var $otherElement = $(param);
    console.log(parseInt(value, 10));
    console.log(parseInt($otherElement.val(), 10));
    return parseInt(value, 10) > parseInt($otherElement.val(), 10);
  });
$.validator.addMethod("lesserThan",
  function(value, element, param) {
    var $otherElement = $(param);
    return parseInt(value, 10) < parseInt($otherElement.val(), 10);
  });
$.validator.addMethod(
  "regex",
  function(value, element, regexp) {
    var re = new RegExp(regexp);
    return this.optional(element) || re.test(value);
  },
  ""
);
