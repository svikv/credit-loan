$(function() {

    $(document).ready(function() {
        $('#paymentTable').DataTable({
            order: [
                [1, 'desc']
            ],
            columnDefs: [{
                targets: [],
                orderable: false
            }]
        });
    });
});