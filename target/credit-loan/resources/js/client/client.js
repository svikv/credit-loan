$(function() {

    $(document).ready(function() {
        $('#clientTable').DataTable({
            order: [
                [1, 'asc']
            ],
            columnDefs: [{
                targets: [2, 3, 4, 5, 6 ],
                orderable: false
            }]
        });
    });
});