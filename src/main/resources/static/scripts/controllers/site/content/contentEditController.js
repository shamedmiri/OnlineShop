app.controller('contentEditCtrl', function ($scope, apiHandler,$rootScope) {
    $scope.data={};
    $scope.id=$rootScope.dataId;
    $scope.editData=()=> {
        if($scope.data.key==undefined||$scope.data.key==null||$scope.data.key==""){
            alert('Please enter key');
            return;
        }
        if($scope.data.value==undefined||$scope.data.value==null||$scope.data.value==""){
            alert('Please enter value');
            return;
        }

        apiHandler.callPut('/api/content/', $scope.data, (response) => {
            debugger;
            $scope.changeMenu('content-list');

        }, (error) => {

        }, true);
    }
        $scope.getData=()=>{
            apiHandler.callGet( "/api/content/"+$scope.id,(response)=>{
                $scope.data=response.dataList[0];
            },(error)=>{

            },true);
        };
        $scope.getData();
    });