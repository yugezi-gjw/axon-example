<html>
<head>
    <style type="text/css">
        table#balance td,
        table#balance th {
            padding: 0px 10px;
        }
    </style>
    <script type="application/javascript" src="/webjars/jquery/2.1.4/jquery.min.js">
    </script>
    <link rel="stylesheet" href="/webjars/bootstrap-css-only/3.3.4/css/bootstrap.min.css">
    <title>Exploring Axon</title>
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Explore CQRS With Axon Framework</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li class="active"><a href="/patient/list">View Patients</a></li>
                <li><a href="/about">About</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" style="margin-top: 70px">
    <div class="row">
        <div class="col-md-6" align="center">
        <table border='0' cellSpacing="1" align="left">
            <tr>
                <td>patientID:</td>
                <td><input id="patient_id" type="text" value="${pat.patientId}"/></td>
                <td>PatNameChinese:</td>
                <td><input id="patient_name_chinese" type="text" value="${pat.patientNameChinese}"/></td>
            </tr>
            <tr>
                 <td>patNameEnglish:</td>
                 <td><input id="patient_name_english" type="text" value="${pat.patientNameEnglish}"/></td>
                 <td>Gender:</td>
                 <td><input id="gender" type="text" value='${pat.gender}''/></td>
             </tr>
             <tr>
                  <td>Birthday:</td>
                  <td><input id="birthday" type="text" value="${pat.birthday}"/></td>
                  <td>IDCard:</td>
                  <td><input id="id_card" type="text" value="${pat.idCard}"/></td>
             </tr>
             <tr>
                  <td>PhoneNumber:</td>
                  <td><input id="phone_number" type="text" value="${pat.phoneNumber}"/></td>
                  <td>Address:</td>
                  <td><input id="address" type="text" value="${pat.address}"/></td>
             </tr>
             <tr>
                <td>AllergyHistory:</td>
                <td><input id="allergy_history" type="text" value="${pat.allergyHistory}"/></td>
                <td><button id="save_patient_btn">保存</button></td>
             </tr>
        </table>
        </div>
    </div>
</div>
<div class="container" style="margin-top: 10px">
    <div class="row">
        <div class="col-md-6">
            <table border='1' cellSpacing="1" align="center" id="patient-table">
            <thead>
            <tr>
                <td>PatientID</td>
                            <td>PatientNameChinese</td>
                            <td>PatientNameEnglish</td>
                            <td>Gender</td>
                            <td>Birthday</td>
                            <td>IDCard</td>
                            <td>PhoneNumber</td>
                            <td>Address</td>
                            <td>AllergyHistory</td>
            </tr>
            </thead>
            <tbody>
            <#list patients as patient>
                <tr id="${patient.patientId}">
                            <td>${patient.patientId}</td>
                            <td>${patient.patientNameChinese}</td>
                            <td>${patient.patientNameEnglish}</td>
                            <td>${patient.gender}</td>
                            <td>${patient.birthday}</td>
                            <td>${patient.idCard}</td>
                            <td>${patient.phoneNumber}</td>
                            <td>${patient.address}</td>
                            <td>${patient.allergyHistory}</td>
                 </tr>
               </#list>
              </tbody>
            </table>
        </div>
    </div>
</div>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-md-6" align="center">
        <table border='0' cellSpacing="1" align="left">
            <tr>
                <td>诊断:</td>
                <td><input id="diagnose" type="text"/></td>
                <td>部位:</td>
                <td><input id="body_part" type="text"/></td>
            </tr>
            <tr>
                <td>预约时间:</td>
                <td><input id="schedule_time" type="text"/></td>
                <td>机器名称:</td>
                <td><input id="terminal" type="text"/></td>
            </tr>
            <tr>
                <td>疗程:</td>
                <td><input id="course" type="text"/></td>
                <td><input type="button" id="schedule-btn" value="预约"/></td>
            </tr>
        </table>
    </div>
</div>
<div class="container" style="margin-top: 10px">
    <div class="row">
        <div class="col-md-6">
            <table border='1' cellSpacing="1" align="left" id="schedule-table">
            <thead>
            <tr>
                <td>PatientID</td>
                <td>患者名</td>
                <td>诊断</td>
                <td>部位</td>
                <td>预约时间</td>
                <td>机器名称</td>
                <td>疗程</td>
            </tr>
            </thead>
            <tbody>

              </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="/script.js"></script>
</html>