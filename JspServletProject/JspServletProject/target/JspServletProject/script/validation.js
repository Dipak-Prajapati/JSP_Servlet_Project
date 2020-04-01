/*alert("This is from Java Script");*/

function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#preview')
                        .attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }


var xFile,xFirst,xMiddle,xLast,xEmail,xDob,xMobile,xGender,xLanguage,xHobbie,xAddress,xPassword,xCPassword;

xFile=xFirst=xMiddle=xLast=xEmail=xDob=xMobile=xGender=xLanguage=xHobbie=xAddress=xPassword=xCPassword=false;

function validate()
{//&& xMname==true
	if(xFile==true && xFirst==true && xMiddle==true && xLast==true && xEmail==true && xDob==true && xMobile==true && 
	xGender==true && xLanguage==true && xHobbie==true && xAddress==true && xPassword==true && xCPassword==true)
	{
		document.getElementById("register").disabled = false;
	}
	else
	{
		document.getElementById("register").disabled = true;
	}
}

function inputFile()
{
	var file = document.getElementById("pic").files[0];
	var fileName = document.getElementById("pic").value;
	var allowed_extensions = new Array("jpg","png","gif");
	var file_extension = fileName.split('.').pop();
	var valid = false;
	
	if(fileName == 0)
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('spic').innerText = "* Please Select Your Profile Pic *";
		xFile=false;
	}
	for(var i = 0; i < allowed_extensions.length; i++)
    {
        if(allowed_extensions[i]==file_extension)
        {
			valid=true;
			
			if(file.size > 2097152)
			{
				document.getElementById('spic').innerText = "* Image Size Must Be Under 2mb *";
				xFile=false;
			} 
			else
			{
				document.getElementById('shead').innerText = " ";
				document.getElementById('spic').innerText = " ";
				xFile=true;
			}
			
        }
    }
	if(valid==false)
	{
		document.getElementById('spic').innerText = "* Please Select The Valid Image *";
		xFile=false;
	}
	validate();
}

function inputfname()
{
	var firstname = document.getElementById("fname");
	var alphaExp = /^[a-zA-Z]+$/;
	
	if (firstname.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sfname').innerText = "* Enter The First Name *";
		//xFirst=false;
		xLast=false;
	}
	else if(firstname.value.match(alphaExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sfname').innerText = " ";
		xFirst=true;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sfname').innerText ="* For Your First Name Please Use Alphabets Only *";
		xFirst=false;
	}
	validate();
}

function inputmname()
{
	var middlename = document.getElementById("mname");
	var alphaExp = /^[a-zA-Z]+$/;
	
	if (middlename.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('smname').innerText = "* Enter The Middle Name *";
		xMiddle=false;
	}
	else if(middlename.value.match(alphaExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('smname').innerText = " ";
		xMiddle=true;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('smname').innerText ="* For Your Middle Name Please Use Alphabets Only *";
		xMiddle=false;
	}
	validate();
}

function inputlname()
{
	var lastname= document.getElementById("lname");
	var alphaExp = /^[a-zA-Z]+$/;

	if (lastname.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('slname').innerText = "* Enter The Last Name *";
		xLast=false;
	}
	else if(lastname.value.match(alphaExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('slname').innerText = " ";
		xLast=true;
	}
	else
	{
		document.getElementById('slname').innerText = "* For Your Last Name Please Use Alphabets Only *";
		xLast=false;
	}	
	validate();
}

function inputemail()
{
	var emailid= document.getElementById("email");
	var emailExp = /^[a-z0-9._][a-zA-Z0-9-_]+@[a-z0-9]+\.[a-z]{2,4}/;

	if(emailid.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('semail').innerText = "* Please Enter The Email *";
		xEmail=false;
	}
	else if(emailid.value.match(emailExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('semail').innerText = " ";	
		xEmail=true;		
	}
	else
	{
		document.getElementById('semail').innerText = "* Please Enter a Valid Email Address *";
		xEmail=false;
	}
	validate();
}

function inputdob()
{
	var birthday= document.getElementById("dob").value;
	
	if(birthday.length == 10)
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sdob').innerText = " ";
		xDob=true;
	}
	else
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sdob').innerText = "* Enter The Valid Date Of Birth *";
		xDob=false;
	}
	validate();
}

function inputmno()
{
	var m_no= document.getElementById("m_no");
	var mobileExp = /^[0-9]{10,10}$/;

	if(m_no.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sm_no').innerText = "* Please Enter The Mobile Number *";
		xMobile=false;
	}
	else if(m_no.value.match(mobileExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sm_no').innerText = " ";
		xMobile=true;
	}
	else
	{
		document.getElementById('sm_no').innerText = "* Please Enter The Valid Mobile Number *";
		xMobile=false;
	}
	validate();
}

function inputgender()
{
	var genders= document.getElementsByName("gender");
	if(genders[0].checked == true)
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sgender').innerText = " ";
		xGender=true;
	}
	else if (genders[1].checked == true) 
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sgender').innerText = " ";
		xGender=true;
	}
	else
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sgender').innerText = "* You Must Select Your Gender *";
		xGender=false;
	}
	validate();
}

function inputlanguage()
{
	var languages= document.getElementsByName("language");
	var check = false;

	for(var i=0;i<languages.length;i++)
	{
		if(languages[i].checked)
		{
			check = true;
			xLanguage=true;
			break;
			
		}
	}
	if(check == false)
	{
		document.getElementById('scheck').innerText = "* Please Select Atleast One Language *";
		xLanguage=false;
	}
	validate();
}
function inputHobbie()
{
	var hobbie = document.getElementById("hobbie").value;
	
	if(hobbie == '')
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('shobbie').innerText = "* Please select an option! *";
		xHobbie=false;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('shobbie').innerText = " ";
		xHobbie=true;
	}
	validate();
}
function inputaddress()
{
	var paddress= document.getElementById("address");
	if(paddress.value == "")
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('saddress').innerText = "* Please Enter The Address *";
		xAddress=false;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('saddress').innerText = " ";
		xAddress=true;
	}
	validate();
}
function inputpassword()
{
	var pwdExp = /^[a-zA-Z0-9]{8,16}$/;
	var password1 = document.getElementById("pwd");
	if(password1.value == '')
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('spwd').innerText = "* Please Enter The Password *";
		xPassword=false;
	}
	else if(password1.value.match(pwdExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = " ";
		xPassword=true;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = "* Password Not In Range *";
		xPassword=false;
	}
	validate();
}
function inputcpassword()
{
	var password1 = document.getElementById("pwd");
	var confirm_password= document.getElementById("cpwd");

	if(confirm_password.value == '')
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('scpwd').innerText = "* Please Enter The Confirm Password *";
		xCPassword=false;
	}
	else if(password1.value != confirm_password.value)
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = " ";
		document.getElementById('scpwd').innerText = "* Password Did Not Match...Please Try Again :( *";
		xCPassword=false;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('scpwd').innerText = " ";
		xCPassword=true;
	}
	validate();
}

function resetFile()
{
	document.getElementById('spic').innerText = " ";
}
function resetFirstName()
{
	document.getElementById('sfname').innerText = " ";
}
function resetMiddleName()
{
	document.getElementById('smname').innerText = " ";
}
function resetLastName()
{
	document.getElementById('slname').innerText = " ";
}
function resetEmail()
{
	document.getElementById('semail').innerText = " ";
}
function resetDob()
{
	document.getElementById('sdob').innerText = " ";
}
function resetMno()
{
	document.getElementById('sm_no').innerText = " ";
}
function resetGender()
{
	document.getElementById('sgender').innerText = " ";
}
function resetLanguage()
{
	document.getElementById('scheck').innerText = " ";
}
function resetHobbie()
{
	document.getElementById('shobbie').innerText = " ";
}
function resetAddress()
{
	document.getElementById('saddress').innerText = " ";
}
function resetPassword()
{
	document.getElementById('spwd').innerText = " ";
}
function resetConfirmPassword()
{
	document.getElementById('scpwd').innerText = " ";
}
/*function validate()
{
	var firstname = document.getElementById("fname");
	var lastname= document.getElementById("lname");
	var emailid= document.getElementById("email");
	var birthday= document.getElementById("dob");
	var m_no= document.getElementById("m_no");
	var genders= document.getElementsByName("gender");
	var hobbie= document.getElementsByName("language");
	var paddress= document.getElementById("address");
	var password= document.getElementById("pwd");
	var confirm_password= document.getElementById("cpwd");

	if (firstname.value == "" || firstname.value == null) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sfname').innerText = "* Enter The First Name *";
		firstname.focus();
		/*return false;*/
/*	}
	
	if(inputfname(firstname,"* For Your First Name Please Use Alphabets Only *"))
	{
		if(inputlname(lastname,"* For Your Last Name Please Use Alphabets Only *"))
		{
			if(inputemail(emailid,"* Please Enter a Valid Email Address *")) 
			{
				if(inputdob(birthday,"* Please Enter The Valid Date Of Birth *"))
				{
					if(inputmno(m_no,"* Please Enter The Valid Mobile Number *")) 
					{
						if(inputgender(genders,"* You Must Select Your Gender *"))
						{
							if(inputhobbie(hobbie,"* Please Select Atleast One Language *"))
							{
								if(inputaddress(paddress,"* Please Enter The Address *"))
								{
									if(inputpassword(password,confirm_password))
									{
										return true;										
									}
								}
							}
						}
					}
					
				}	
			}
		}
	}
	return false;
}
function inputfname(firstname,alertmsg)
{
	var alphaExp = /^[a-zA-Z]+$/;

	if(firstname.value.match(alphaExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sfname').innerText = " ";
		return true;
	}
	else
	{
		document.getElementById('sfname').innerText = alertmsg;
		firstname.focus();
		return false;
	}
}

function inputlname(lastname,alertmsg)
{
	var alphaExp = /^[a-zA-Z]+$/;

	if (lastname.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('slname').innerText = "* Enter The Last Name *";
		lastname.focus();
		return false;
	}
	else if(lastname.value.match(alphaExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('slname').innerText = " ";
		return true;
	}
	else
	{
		document.getElementById('slname').innerText = alertmsg;
		lastname.focus();
		return false;
	}	
}

function inputemail(emailid,alertmsg)
{
	var emailExp = /^[w-.+]+@[a-zA-Z0-9.-]+.[a-zA-z0-9]{2,4}$/;

	if(emailid.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('semail').innerText = "* Please Enter The Email *";
		emailid.focus();
		return false;
	}
	else if(emailid.value.match(emailExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('semail').innerText = " ";
		return true;
	}
	else
	{
		document.getElementById('semail').innerText = alertmsg;
		emailid.focus();
		return false;
	}
}

function inputdob(birthday,alertmsg)
{
	var today = new Date();
	var inputdate = new Date(birthday.value);

	if(inputdate.value == " ") 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sdob').innerText = "* Enter The Date Of Birth *";
		birthday.focus();
		return false;
	}
	else if(inputdob >= today)
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sdob').innerText = alertmsg;
		birthday.focus();
		return false;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sdob').innerText = " ";
		return true;
	}
}

function inputmno(m_no,alertmsg)
{
	var mobileExp = '^\+?\d{0,13}';

	if(m_no.value.length == 0) 
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sm_no').innerText = "* Please Enter The Mobile Number *";
		m_no.focus();
		return false;
	}
	else if(m_no.value.match(mobileExp))
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sm_no').innerText = " ";
		return true;
	}
	else
	{
		document.getElementById('sm_no').innerText = alertmsg;
		m_no.focus();
		return false;
	}
}

function inputgender(gender,alertmsg)
{
	if(genders[0].checked == true)
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sgender').innerText = " ";
		return true;
	}
	else if (genders[1].checked == true) 
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('sgender').innerText = " ";
		return true;
	}
	else
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('sgender').innerText = alertmsg;
		return true;
	}
}

function inputhobbie(hobbie,alertmsg)
{
	var check = false;

	for(var i=0;i<hobbie.length;i++)
	{
		if(hobbie[i].checked)
		{
			check = true;
			break;
		}
	}
	if(check == false)
	{
		document.getElementById('scheck').innerText = alertmsg;
		return false;
	}
	return true;
}

function inputaddress(paddress,alertmsg)
{
	if(paddress.value == "")
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('saddress').innerText = alertmsg;
		return false;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('saddress').innerText = " ";
		return true;
	}
}
function inputpassword(password,confirm_password)
{
	if(password.value == '')
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('spwd').innerText = "* Please Enter The Password *";
		return false;
	}
	else if(confirm_password.value == '')
	{
		document.getElementById('shead').innerText = "* All Fields Are Mandatory *";
		document.getElementById('scpwd').innerText = "* Please Enter The Confirm Password *";
		return false;
	}
	else if(password != confirm_password)
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = " ";
		document.getElementById('scpwd').innerText = "* Password Did Not Match...Please Try Again :( *";
		return false;
	}
	else
	{
		document.getElementById('shead').innerText = " ";
		document.getElementById('spwd').innerText = " ";
		document.getElementById('scpwd').innerText = " ";
		return true;
	}
}*/
