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
        //http://kkucleft.kku.ac.th/app_admin/index.php/welcome/update_patient
        function   update_patient()
        {
              //echo "T";
              echo $id_patient=trim($this->input->get_post("txt_id_patient"));
              echo "<br>";
              echo $name=trim($this->input->get_post("txt_name"));
              echo "<br>";
              //  $('#txt_lastname').textbox('setValue',row.lastname); 
              echo  $lastname=trim($this->input->get_post("txt_lastname"));
              echo "<br>";
              //txt_id_card
              echo  $id_card=trim($this->input->get_post("txt_id_card"));
              echo "<br>";
              //txt_telephone
              echo  $telephone=trim($this->input->get_post("txt_telephone"));
              echo "<br>";
              //r_id_sex
               echo  $r_id_sex=trim($this->input->get_post("r_id_sex"));
              echo "<br>";
              //txt_birthdate
              echo  $birthdate=trim($this->input->get_post("txt_birthdate"));
             
              if(   !empty($birthdate)    )
              {
                   $ex=explode("/" , $birthdate );
                   echo    $conv_birthdate =  $ex[2]."-".$ex[0]."-".$ex[1]; 
                   echo "<br>";
              }
              //txt_address
              echo  $address=trim($this->input->get_post("txt_address"));
              echo "<br>";
              //cmb_province_id
               echo  $province_id=trim($this->input->get_post("cmb_province_id"));
              echo "<br>";
              //txt_diagnosis
              echo  $diagnosis=trim($this->input->get_post("txt_diagnosis"));
              echo "<br>";
              //txt_detail_diagnosis
              echo  $detail_diagnosis=trim($this->input->get_post("txt_detail_diagnosis"));
              echo "<br>";
              //txt_informative_name
               echo  $informative_name=trim($this->input->get_post("txt_informative_name"));
               echo "<br>";
              //txt_informative_lastname
               echo  $informative_lastname=trim($this->input->get_post("txt_informative_lastname"));
               echo "<br>";
               //name="txt_informative_tel" 
                echo  $informative_tel=trim($this->input->get_post("txt_informative_tel"));
                 echo "<br>";
               
               
                $tb="tb_patientcleft";
                $data=array(
                     "name" => $name,
                );
                $this->db->where("id_patient",$id_patient);
                $ck=$this->db->update($tb,$data);
                if( $ck )
                {
                    echo 1;
                }else
                {
                    echo 0;
                }
              
        }
        

}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */
