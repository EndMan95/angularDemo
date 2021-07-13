var app = angular.module("HumanManagement", []);
 
// Controller Part
app.controller("HumanController", function($scope, $http) {
 
 
    $scope.humans = [];
    $scope.humanForm = {
        humanId: 1,
        name: "",
        sex: ""
    };
 
    _refreshData();
 
    $scope.submitHuman = function() {
 
        var method = "";
        var url = "";
 
        if ($scope.humanForm.humanId == -1) {
            method = "POST";
            url = '/human';
        } else {
            method = "PUT";
            url = '/human';
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.humanForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };
 
    $scope.createHuman = function() {
        _clearFormData();
    }

    $scope.deleteHuman = function(human) {
        $http({
            method: 'DELETE',
            url: '/human/' + human.humanId
        }).then(_success, _error);
    };
 
    $scope.editHuman = function(human) {
        $scope.humanForm.humanId = human.humanId;
        $scope.humanForm.name = human.name;
        $scope.humanForm.sex = human.sex;
    };
 
    function _refreshData() {
        $http({
            method: 'GET',
            url: '/humans'
        }).then(
            function(res) { // success
                $scope.humans = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.humanForm.humanId = -1;
        $scope.humanForm.name = "";
        $scope.humanForm.sex = ""
    };
});