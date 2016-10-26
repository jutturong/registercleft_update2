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
                     rownumbers:true,
                     singleSelect:true,
                     columns:[[
                         { field:'name', title:'ชื่อผู้ป่วย' ,align:'left' , editor:'text' ,  },
                         { field:'lastname',title:'นามสกุลผู้ป่วย',align:'left' },
 
                     ]],
                         
                       
                         
                         toolbar:[
                     {  text:'Reload',iconCls:'icon-reload' , handler:function(){  $('#dg_main1').datagrid('reload'); } }
                         ]
                 });
               
           });
        </script>

    </head>  
    
    <body>
       
        <div class="easyui-datagrid"  id="dg_main1" style="width:500px;height: 400px;"   >
            
            
        </div>
    </body>
    
</html>    