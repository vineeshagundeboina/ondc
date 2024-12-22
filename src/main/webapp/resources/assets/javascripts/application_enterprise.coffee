$(document).on 'click', '.clear_fields', ->
  $('.readonly').empty()
  $("input.readonly:text").val("")
  $('.users_form').hide();
  $('.readonly').prop('readonly', false)
  return
