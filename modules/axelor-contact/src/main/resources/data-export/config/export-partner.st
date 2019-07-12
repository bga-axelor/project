<?xml version="1.0" encoding="utf-8"?>




<partner>
  <fullName>$fullName$</fullName>
  <title>$title$</title>
  <firstName>$firstName$</firstName>
  
  <lastName>$lastName$</lastName>
   <email>$email$</email>
   <mno>$mno$</mno>
   
<dateOfBirth>$dateOfBirth$</dateOfBirth>
   
   $addresses:{it |
   <address>
   <street>$it.street$</street>
   <area>$it.area$</area>
     <city>$it.city$</city>
     <state>$it.state$</state>
 <zip>$it.zip$</zip>
     <country>$it.country$</country>
      
   </address>
   
   
   }$
   
     <company>$company.name$</company>
</partner>