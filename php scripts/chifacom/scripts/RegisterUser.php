<?php

require_once '../includes/DbOperations.php';
$response = array();

if($_SERVER['REQUEST_METHOD']=='POST'){
	
	if(
	      isset($_POST['doctor_firstname']) and
		  isset($_POST['doctor_lastname']) and
		  isset($_POST['doctor_speciality']) and
		  isset($_POST['birthdate']) and
		  isset($_POST['phone']) and
		  isset($_POST['office_mail']) and
		  isset($_POST['office_type']) and
		  isset($_POST['doctor_address'])
		 
	){
		
		$db = new DbOperations();
		if ($db->doctorRegisterOffice(
		       $_POST['office_mail'],
			   $_POST['office_type'],
			   $_POST['phone']
		)){
			$user = $db->getUserByUsername($_POST['email']);
			if ($db->doctorRegister(
		       $_POST['doctor_firstname'],
			   $_POST['doctor_lastname'],
			   $_POST['doctor_address'],
			   $_POST['doctor_speciality'],
			   $_POST['birthdate'],
			   $user['office_id']
		)){
			
			
			
			$response['error'] = false ;	
	        $response['message'] = "Client registered Successfully" ;
		}else{
			$response['error'] = true ;	
	        $response['message'] = "Some error occured 111 , please try again !" ;
		}
			
		}else{
			$response['error'] = true ;	
	        $response['message'] = "Some error occured 222, please try again !" ;
		}
		
	}else{
		$response['error'] = true ;	
	    $response['message'] = "Required fields are missing" ;
	}
	
}else{
	
    $response['error'] = true ;	
	$response['message'] = "Invalid Request" ;
	
}

echo json_encode($response);