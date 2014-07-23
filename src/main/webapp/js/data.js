$(document).ready(function() {
    $("#report-table").dataTable({
        "bProcessing": true,
        "sAjaxDataProp": "",
        "iDisplayLength": 25,
        "sAjaxSource": 'GetStats',
        "aaSorting": [[ 1, "desc" ]],
        "aoColumns": [
            {"mData": "username"},
            {"mData": "kills"},
            {"mData": "deaths"},
            {"mData": "kdratio"},
            {"mData": "played"}
        ]
    });
});
