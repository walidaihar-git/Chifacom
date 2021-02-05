<?php

require_once '../includes/DbOperations.php';
$response = array();

if($_SERVER['REQUEST_METHOD']=='POST'){
	
	if(isset($_POST['office_mail']) and isset($_POST['office_pass'])){
		       
	  	$db = new DbOperations();
		
		if($db->userLogin($_POST['office_mail'],$_POST['office_pass'])){
			//phpinfo();
			if($db->isActive($_POST['office_mail'],$_POST['office_pass'])){
			$user = $db->getUserByUsername($_POST['office_mail']);
			$doctor = $db -> getDoctorByUsername($user['office_id']);
			$address = $db -> getAddressByUsername($doctor['doctor_address']);
			$response['error'] = false ; 
			$response['office_id'] = $user['office_id'];
			$response['office_mail'] = $user['office_mail'];
			$response['office_type'] = $user['office_type'];
			$response['phone'] = $user['phone'];
			$response['office_createdAt'] = $user['office_createdAt'];
			$response['doctor_firstname'] = $doctor['doctor_firstname'];
			$response['doctor_firstname_AR'] = $doctor['doctor_firstname_AR'];
			$response['doctor_lastname'] = $doctor['doctor_lastname'];
			$response['doctor_lastname_AR'] = $doctor['doctor_lastname_AR'];
		    //$response['doctor_address'] = $doctor['doctor_address'];
			$response['doctor_speciality'] = $doctor['doctor_speciality'];
			$response['birthdate'] = $doctor['birthdate'];
			$response['birthplace'] = $doctor['birthplace'];
			$response['office_location'] = $address['office_location'];
			$response['province'] = $address['province'];
			$response['state'] = $address['state'];
			$response['address_link'] = $address['address_link'];
			$response['address_lat'] = $address['address_lat'];
			$response['address_long'] = $address['address_long'];
			
			}else{
				$response['error'] = true ;	
	            $response['message'] = "Your Account is not activated !" ;
			}
			
		}else{
			
			$response['error'] = true ;	
	    $response['message'] = "Invalid username or You are not registred !" ;
			
		}
		
		
	}else{
		
		$response['error'] = true ;	
	    $response['message'] = "Erreur in login !, Required fields are missing" ;
		
	}
}

echo json_encode($response);