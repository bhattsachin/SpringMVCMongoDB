<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Checkin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
      	<link href="http://twitter.github.com/bootstrap/1.4.0/bootstrap.min.css" rel="stylesheet">
        <link href="http://datatables.net/media/blog/bootstrap/DT_bootstrap.css" rel="stylesheet">
        <script src="http://datatables.net/release-datatables/media/js/jquery.js" type="text/javascript">
        </script>
        <script src="http://datatables.net/release-datatables/media/js/jquery.dataTables.js" type="text/javascript">
        </script>
        
        
        
        <!-- <link href="/static/css/bootstrap.min.css" rel="stylesheet">
        <link href="/static/css/dt_bootstrap.css" rel="stylesheet">
        <script src="/static/js/jquery-1.7.1.js" type="text/javascript">
        </script>
        <script src="/static/js/jquery.datatables.js" type="text/javascript">
        </script> -->
      
        <!-- Include Bootstrap Asserts JavaScript Files. -->
        
        <script type="text/javascript">
                        $(document).ready(function(){
                            $('#checkins').dataTable({
                                "bProcessing" : true,
								"bRetrieve" : false,
								"bLengthChange" : false,
								"bPaginate" : false,
								"bServerSide" : true,
								"bSort" : true,
								"bFilter" : true,
								"bInfo" : false,
                                "sAjaxSource": "getalljson"
            					
                            });
                        });
                    
        </script>
    </head>
    <body>
    Logs
        <div class="container">
            <table width = "400" cellpadding="0" cellspacing="0" border="0" class="display bordered-table zebra-striped" id="checkins">
                <thead>
                    <tr>
                        <th>
                            Request Type
                        </th>
                        <th>
                            Params
                        </th>
                        <th>
                            timestamp	
                        </th>
                        <th>
                            uid
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td colspan="5" class="dataTables_empty">
                            Loading data from server
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <th>
                        </th>
                        <th>
                        </th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </body>
</html>
