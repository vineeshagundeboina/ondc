(function() {
    'use strict';
    window.addEventListener('load', function() {
        console.log('load....');
        var form = document.getElementById('needs-validation');
        if(form){
          form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        };
    }, false);
})();


function alert_box(key, message) {
    var alert_icon = (key == 'danger') ? 'fa-exclamation-triangle' : 'fa-check'
    $('.modal-header').addClass("bg-"+key)
    $('.modal-body').addClass("text-"+key)
    $('.fa').addClass(alert_icon)
    $('.modal-data').html(message)
    $('#alert-box').modal('toggle');
}