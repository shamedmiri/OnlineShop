app.controller('contentAddCtrl',['$scope','apiHandler','textAngularManager', function ($scope, apiHandler, textAngularManager) {
    $scope.data={};
    $scope.addData=()=>{
        if($scope.data.key==undefined||$scope.data.key==null||$scope.data.key==""){
            alert('Please enter key');
            return;
        }
        if($scope.data.value==undefined||$scope.data.value==null||$scope.data.value==""){
            alert('Please enter value');
            return;
        }

        apiHandler.callPost('/api/content/',$scope.data,(response)=>{
            $scope.changeMenu('content-list');
        },(error)=>{
        },true);
    }

}]);