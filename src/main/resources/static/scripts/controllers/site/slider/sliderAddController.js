app.controller('sliderAddCtrl', function ($scope, apiHandler,$rootScope) {
    $scope.data={};
    $scope.addData=()=>{
        $scope.data.image=$rootScope.uploadFile;
        if($scope.data.title==undefined||$scope.data.title==null||$scope.data.title==""){
            alert('Please enter title');
            return;
        }
        if($scope.data.link==undefined||$scope.data.link==null||$scope.data.link==""){
            alert('Please enter link');
            return;
        }
        if($scope.data.enable==undefined||$scope.data.enable==null){
            alert('Please set enable');
            return;
        }if($scope.data.image==undefined||$scope.data.image==null||$scope.data.image==''){
            alert('Please upload an image');
            return;
        }

        apiHandler.callPost('/api/Slider/',$scope.data,(response)=>{
            $scope.changeMenu('slider-list');

        },(error)=>{

        },true);
    }

})