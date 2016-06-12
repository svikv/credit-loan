$(function() {

    $(document).ready(function() {
        $('#creditLineTable').DataTable({
            order: [
                [1, 'asc']
            ],
            columnDefs: [{
                targets: [7,8],
                orderable: false
            }]
        });
    });
});