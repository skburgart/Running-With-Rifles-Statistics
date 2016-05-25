/**
 * Copyright (c) 2014 Steven Burgart <skburgart@gmail.com>
 * See the file license.txt for copying permission.
 */
$(document).ready(function () {
    $("#player-stats-table").dataTable({
        "bProcessing": true,
        "sAjaxDataProp": "",
        "iDisplayLength": 25,
        "sAjaxSource": 'stats',
        "aaSorting": [[1, "desc"]],
        "aoColumns": [
            {"mData": "username",
                "mRender": function (data, type, row) {
                    return "<img title='" + row['rank'] + "' height='25' src='img/rank/" + row['rank'] + ".png' />" + data;
                }},
            {"mData": "experience", "sClass": "alignRight", "sType:": "numeric"},
            {"mData": "kills", "sClass": "alignRight", "sType:": "numeric"},
            {"mData": "deaths", "sClass": "alignRight", "sType:": "numeric"},
            {"mData": "longestKillStreak", "sClass": "alignRight", "sType:": "numeric"},
            {
                "mData": "killDeathRatio",
                "sClass": "alignRight",
                "sType:": "numeric",
                "mRender": function (data, type, row) {
                    return data.toFixed(2);
                }
            },
            {
                "mData": "killsPerMinute",
                "sClass": "alignRight",
                "sType:": "numeric",
                "mRender": function (data, type, row) {
                    return data.toFixed(2);
                }
            },
            {"mData": "timePlayedString", "sClass": "alignRight", "sType:": "numeric", "iDataSort": 9},
            {"mData": "lastSeenPretty", "sClass": "alignRight", "sType:": "numeric", "iDataSort": 10},
            // Hiden values (for sorting)
            {"mData": "timePlayed", "bVisible": false},
            {"mData": "lastSeen", "bVisible": false}
        ]
    });
});
