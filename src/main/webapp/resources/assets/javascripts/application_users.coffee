# Place all the behaviors and hooks related to the matching controller here.
# All this logic will automatically be available in application.js.
# You can use CoffeeScript in this file: http://coffeescript.org/
$(document).on 'click', '.close-icon', ->
  user_form = $(this).closest('.user-form')
  user_id = user_form.find('#application_form_application_enterprise_attributes_application_users_attributes__id').val()
  unless /^\s*$/.test(user_id)
    enterprise_id = $('#application_form_application_enterprise_attributes_id').val()
    $.ajax '/admin/application_users/user_delete',
      type: 'POST'
      dataType: 'json'
      data: { application_user_id: user_id, enterprise_id: enterprise_id }
      error: (jqXHR, textStatus, errorThrown) ->
        alert 'error' + errorThrown
      success: (data, textStatus, jqXHR) ->
        console.log data

  length = $('.user-form').length
  if length == 2
    $('.remove').hide();
    user_form.slideUp ->
      $(this).remove()
      # max_value = parseInt($('.user_auth')[0].max)
      max_value = $('.user-form').length
      $('.user_auth').prop('max', max_value - 1 )
    return
  else
  user_form.slideUp ->
    $(this).remove()
    # max_value = parseInt($('.user_auth')[0].max)
    max_value = $('.user-form').length
    $('.user_auth').prop('max', max_value - 1 )
    return

$(document).on 'click', '.auto_load_users', ->
  acc_no = $('#application_form_application_enterprise_attributes_acc_no').val()
  cust_nos = $('.related_parties').find('[id$=_cust_no]').map(->
    $(this).val()
  ).get()
  jQuery.post '/admin/application_users/user_auto_load', 'acc_no': acc_no, 'existing_users': cust_nos
  return
