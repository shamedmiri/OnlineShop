app.controller("panelCtrl", function ($scope, apiHandler, $cookies, $rootScope) {
    $scope.template = "views/dashboard.html";
    $scope.templateName = "dashboard";
    $scope.templateGroup="dashboard";
    $scope.checkAccess = () => {
        let token = $cookies.get("userToken");
        if (token == "" || token == undefined || token == null) {
            location.href = "/login";
            return;
        }
        $scope.getUserInfo();
    }
    $scope.getUserInfo = () => {
        apiHandler.callGet('/api/user/getUserInfo', (response) => {
            $rootScope.userInfo = response.dataList[0];
            $scope.user = $rootScope.userInfo;
        }, (error) => {

        }, true)
    }
    $scope.changeMenu = (templateName) =>{
        $scope.templateName = templateName;
        $scope.template = $scope.getMenuPrefix(templateName);
        $scope.templateGroup=$scope.getMenuGroup(templateName);

    }
    $scope.getMenuPrefix=(templateName)=> {
        switch (templateName) {
            case 'nav-list':
                return 'views/site/nav/' + templateName + '.html';
            case 'nav-add':
                return 'views/site/nav/' + templateName + '.html';
            case 'nav-edit':
                return 'views/site/nav/' + templateName + '.html';
            case 'content-list':
                return 'views/site/content/' + templateName + '.html';
            case 'content-add':
                return 'views/site/content/' + templateName + '.html';
            case 'content-edit':
                return 'views/site/content/' + templateName + '.html';
            case 'slider-list':
                return 'views/site/slider/' + templateName + '.html';
            case 'slider-add':
                return 'views/site/slider/' + templateName + '.html';
            case 'slider-edit':
                return 'views/site/slider/' + templateName + '.html';
            case 'uploader':
                return 'views/utils/' + templateName + '.html';
            default:
                return 'views/dashboard.html';
        }
    }
    $scope.getMenuGroup=(templateName)=> {
        if(templateName==='dashboard'){
            return 'dashboard';
        }else if(templateName==="nav-list"||templateName==='nav-edit'||templateName==='nav-add'){
            return  'nav';
        }else if(templateName==="content-list"||templateName==='content-edit'||templateName==='content-add'){
            return  'content';
        }else if(templateName==="slider-list"||templateName==='slider-edit'||templateName==='slider-add'){
        return  'slider';
    }else if(templateName==="uploader"){
            return  'uploader';
        }else{
            return 'dashboard';
        }
    }
        $scope.checkAccess();
});