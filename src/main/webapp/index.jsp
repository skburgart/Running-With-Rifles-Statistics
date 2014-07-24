<%@page import="com.skburgart.rwr.RWRConfig"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Steven Burgart">
        <title>RWR Stats</title>
        <link href="bootstrap-3.2.0-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="datatables-1.9.4/css/jquery.dataTables.css" rel="stylesheet">
        <link href="css/index.css" rel="stylesheet">
        <link rel="icon" type="image/x-icon" href="img/favicon.ico" />
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=""><%=RWRConfig.get("web.title")%></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="http://www.modulaatio.com/rwr_server_list/view_servers.php">Public Server List</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="stats-table-container">
            <table id="player-stats-table">
                <thead>
                    <tr>
                        <th>Player</th>
                        <th>XP</th>
                        <th>Kills</th>
                        <th>Deaths</th>
                        <th>Streak</th>
                        <th>K/D Ratio</th>
                        <th>Kills/Min</th>
                        <th>Played</th>
                        <th>Last Seen</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- auto-generated -->
                </tbody>
            </table>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
        <script src="datatables-1.9.4/js/jquery.dataTables.min.js"></script>
        <script src="js/data.js"></script>
    </body>
</html>
