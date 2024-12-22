$(document).on 'click', '.load_details', ->
  acc_no = $('#application_form_application_enterprise_attributes_acc_no').val()
  jQuery.post '/admin/application_forms/load_account_details', 'acc_no': acc_no
  return

$(document).on 'blur', '#application_form_application_enterprise_attributes_pref_corp', ->
  pref_corp = $(this)
  enterprise_id = $('#application_form_application_enterprise_attributes_id').val()
  error_container =  pref_corp.parent().find('div')
  console.log(error_container);
  if pref_corp.val().length > 2
    $.ajax '/admin/application_forms/validate_pref_corp',
      type: 'POST'
      dataType: 'json'
      data: { pref_corp: pref_corp.val(), enterprise_id: enterprise_id }
      error: (jqXHR, textStatus, errorThrown) ->
        console.log('...')
      success: (data, textStatus, jqXHR) ->
        if data['error'] && data['error']['code'] == '402'
          error_message = data['error']['message']
          error_label = document.createElement("label");
          error_label.setAttribute('id', pref_corp.attr('id')+'-error')
          error_label.className = 'error'
          error_label.innerHTML = error_message
          pref_corp.parent().append(error_label)
          pref_corp[0].setCustomValidity(error_message)
        else
          error_label = $('#'+pref_corp.attr('id')+'-error')
          error_label.remove()
          pref_corp[0].setCustomValidity('')
          error_container.hide()
  return