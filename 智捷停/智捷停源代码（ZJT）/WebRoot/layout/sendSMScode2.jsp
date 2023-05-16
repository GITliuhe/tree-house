<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <script type="text/javascript">

    var sms="";
    $("#btn").click(function(){
        var phone=$("#phoneNumber").val();
        if(phone!="")
        {
            $.ajax({
                url:"sendSMS",
                type:"post",
                data:{"phone":phone},
                success:function(result){
                    sms=result;
                }
            });
        }else{
             alert("请输入手机号");
            return false;
        }

    });
    $("#lo").click(function(){
        var code=$("#code").val();
        if(code==""){
            alert("请输入验证码");
        }else{
            if(sms==code){
                $("form").submit();
            }else{
                alert("验证码错误");

            };
        };

    });
</script>
