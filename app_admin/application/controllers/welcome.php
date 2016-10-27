<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Welcome extends CI_Controller {

    //$this->load->library('encrypt');

  //  var  $title=" ศูนย์ตะวันฉาย มหาวิทยาลัยขอนแก่น | TAWANCHAI KhoenKean University Version 1.0 "; //The Entrar-shadow Website form | w3layouts
    var  $title=" ระบบฐานข้อมูลทางทันตกรรมผู้ป่วยปากแหว่ง เพดานโหว่ และความพิการแต่กำเนิดของใบหน้าและกะโหลกศีรษะในศูนย์ตะวันฉาย มหาวิทยาลัยขอนแก่น | TAWANCHAI KhoenKean University Version 1.0 "; //The Entrar-shadow Website form | w3layouts
    var  $title_fr1=" ระบบการติดตามการรักษา version 1.0 ";

  function __construct()
        {

            parent::__construct();
            //$this->load->library('encrypt');

        }


  public function index()
	{
		//$this->load->view('welcome_message');
                $data['title']= $this->title;
                $this->load->view('login',$data);
	}
        public  function checklogin()
        {
            //echo "testing page";
             $data['title']= $this->title;
              $data['title_fr1']= $this->title_fr1;

             $data["tr1"]="บำบัดทางทันตกรรมจัดฟันก่อนการศัลยกรรมสำหรับทารก (PSOT)";
             $data["tr2"]="ตรวจความพิการทางประสาท";
             $data["tr3"]="ตรวจภาวะแทรกซ้อนทางพันธุกรรม";
             $data["tr4"]="แ้ก้ไขการให้อาหารและเลี้ยงดูทารกที่มีภาวะปากแหว่งเพดานโหว่";
             $data["tr5"]="MRI, CT scan";
             $data["tr6"]="ผ่าตัดศัลยกรรมตกแต่งริมฝีปาก (Cheiloplasty)";
             $data["tr7"]="ผ่าตัดศัลยกรรมเพดานปาก (Palatoplasty)";
             $data["tr8"]="รักษาความบกพร่องของเพดานอ่อนและผนังคอหอย";
             $data["tr9"]="แก้ไขปัญหาการได้ยิน";
             $data["tr10"]="บำบัดทางทันตกรรมจัดฟัน";
             $data["tr11"]="ปลูกถ่ายกระดูกสันเหงือก";
             $data["tr12"]="ผ่าตัดตกแต่งกระดูกขากรรไกร";
             $data["tr13"]="ยืดถ่างขยายกระดูกขากรรไกร";
             $data["tr14"]="ฝึกการพูด";

            // $this->load->view('home',$data);
             $this->load->view('mainpage',$data);
        }
        //http://127.0.0.1/app_admin/index.php/welcome/json_main1
        //http://kkucleft.kku.ac.th/app_admin/index.php/welcome/json_main1
        public function json_main1()
        {
             //FROM `tb_patientcleft` 
            //SELECT * FROM `province` 
             //PROVINCE_CODE
            
             $tb="tb_patientcleft";
             $tb1="province";
             
             $this->db->join($tb1, $tb1.".PROVINCE_CODE=".$tb.".province_id" ,"left");
             
             
             $q=$this->db->get($tb);
             foreach($q->result() as $row )
             {
                 $rows[]=$row;
             }
             echo json_encode($rows);
             
            
        }
        //http://kkucleft.kku.ac.th/app_admin/index.php/welcome/json_province
        public function json_province()
        {
             $tb="province";
             $q=$this->db->get($tb);
             foreach($q->result() as $row)
             {
                 $rows[]=$row;
                 
             }
             echo json_encode($rows);
        }
        

}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */
