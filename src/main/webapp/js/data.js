$(document).ready(function() {
    $("#report-table").dataTable({
        "bProcessing": true,
        "sAjaxDataProp": "",
        "iDisplayLength": 25,
        "sAjaxSource": 'GetStats',
        "aaSorting": [[ 1, "desc" ]],
        "aoColumns": [
            {"mData": "username"},
            {"mData": "xp", "sClass" : "alignRight", "sType:": "numeric"},
            {"mData": "kills", "sClass" : "alignRight", "sType:": "numeric"},
            {"mData": "deaths", "sClass" : "alignRight", "sType:": "numeric"},
            {"mData": "streak", "sClass" : "alignRight", "sType:": "numeric"},
            {"mData": "kdratio", "sClass" : "alignRight", "sType:": "numeric"},
            {"mData": "kpm", "sClass" : "alignRight", "sType:": "numeric"},
            {"mData": "played", "sClass" : "alignRight", "sType:": "numeric", "iDataSort": 9},
            {"mData": "lastseen", "sClass" : "alignRight", "sType:": "numeric", "iDataSort": 10},
            // Hiden values (for sorting)
            {"mData": "playedseconds", "bVisible": false},
            {"mData": "lastseenseconds", "bVisible": false}
        ]
    });
});
