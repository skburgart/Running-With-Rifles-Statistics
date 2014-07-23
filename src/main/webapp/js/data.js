$(document).ready(function() {
    $("#report-table").dataTable({
        "bProcessing": true,
        "sAjaxDataProp": "",
        "iDisplayLength": 25,
        "sAjaxSource": 'GetStats',
        "aaSorting": [[ 1, "desc" ]],
        "aoColumns": [
            {"mData": "username"},
            {"mData": "xp", "sType:": "numeric"},
            {"mData": "kills", "sType:": "numeric"},
            {"mData": "deaths", "sType:": "numeric"},
            {"mData": "kdratio", "sType:": "numeric"},
            {"mData": "kpm", "sType:": "numeric"},
            {"mData": "played", "sType:": "numeric"}
        ]
    });
});
