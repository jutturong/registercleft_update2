<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><?=$title?></title>


        <?=$this->load->view("import_")?>
        
        <script type="text/javascript">
           $(function(){
                 $('#dg_main1').datagrid({
                     title:'ระบบฐานข้อมูลแจ้งเกิดเด็กปากแหว่งเพดานโหว่',
                     iconCls:'icon-man',
                     url:'<?=base_url()?>index.php/welcome/json_main1',
                     columns:[[
                         { field:'name', title:'ชื่อ' ,align:'left' }
                     ]]
                 });
               
           });
        </script>

    </head>  
    
    <body>
       
        <div class="easyui-datagrid"  id="dg_main1" style="width:500px;height: 400px;"   >
            
            
        </div>
    </body>
    
</html>    