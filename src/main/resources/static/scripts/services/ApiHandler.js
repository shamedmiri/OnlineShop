app.service("apiHandler",function ($http,$cookies) {
    this.callPost=(url,data,onSuccess,onError,setToken)=>{
        let request={
            url:url,
            method:'POST',
            data:data
        };

        if(setToken){
            let token=$cookies.get("userToken");
            request.headers={
                'Authorization':'Bearer '+token
            };
        }
        $http(request).then((response)=>{
            if(response!=null && response.data!=null){
                let result=response.data;
                if(result.status=="SUCCESS"){
                    onSuccess(result);
                }else if(result.hasError){
                    alert(result.message);
                }else{
                    alert("unknown error");
                }
            }
        },(error)=>{
            alert("Exception");
            onError(error);
        });
    }
    this.callGet=(url,onSuccess,onError,setToken)=>{
        let request={
            url:url,
            method:'GET'
        };
        if(setToken){
            let token=$cookies.get("userToken");
            request.headers={
                'Authorization':'Bearer '+token
            };
        }
        $http(request).then((response)=>{
            if(response!=null && response.data!=null){
                let result=response.data;
                if(response.status=="SUCCESS" || response.status==200){
                    onSuccess(result);
                }else if(response.hasError){
                    alert(result.message);
                }else{
                    alert("unknown error");
                }
            }
        },(error)=>{
            alert("Exception");
            onError(error);
        },true);
    }
    this.callPut=(url,data,onSuccess,onError,setToken)=>{
        let request={
            url:url,
            method:'PUT',
            data:data
        };
        if(setToken){
            let token=$cookies.get("userToken");
            request.headers={
                'Authorization':'Bearer '+token
            };
        }
        $http(request).then((response)=>{
            if(response!=null && response.data!=null){
                let result=response.data;
                if(response.status=="SUCCESS" || response.status==200){
                    onSuccess(result);
                }else if(response.hasError){
                    alert(result.message);
                }else{
                    alert("unknown error");
                }
            }
        },(error)=>{
            alert("Exception bad item");
            onError(error);
        });
    }
    this.callDelete=(url,onSuccess,onError,setToken)=>{
        let request={
            url:url,
            method:'DELETE',
        };

        if(setToken){
            let token=$cookies.get("userToken");
            request.headers={
                'Authorization':'Bearer '+token
            };
        }
        $http(request).then((response)=>{
            if(response!=null && response.data!=null){
                let result=response.data;
                if(response.status=="SUCCESS" || response.status==200){
                    onSuccess(result);
                }else if(response.hasError){
                    alert(result.message);
                }else{
                    alert("unknown error");
                }
            }
        },(error)=>{
            alert("Exception");
            onError(error);
        });
    }
})