/**
 * 
 */

var appTypePersonne = angular.module("typePersonneApp", []);
appTypePersonne.constant("urlAllData","http://localhost:8080/typePersonnes" ) ;


appTypePersonne.controller("typePersonneController", function($scope, $http , urlAllData ) {
	$scope.data = null;
	$scope.recherche =null;
	$scope.editingData = {};

	$scope.viewAll = function() {		
		$http.get(urlAllData).success(function(data) {
			$scope.data = data;
			
			for (var i = 0, length = $scope.data.length; i < length; i++) {				
				$scope.editingData[$scope.data[i].id] = false;				
			}
		});
	}
	
	$scope.modify = function(tp) {
		$scope.editingData[tp.id] = true;
	};

	$scope.update = function(tp) {
		$scope.editingData[tp.id] = false;
		$http({
			method:"PUT",
			url :urlAllData ,
			data: {"id":tp.id ,"nom" :tp.nom },
			headers :{'Content-Type' :'application/json'}
		}).success(function(data){
			$scope.message ="add ok" ;
			$scope.viewAll() ; 
		});		
	};
	
	$scope.viewOne = function() {
		console.log("-----methode Afficher by one----"+$scope.recherche);
		$http({
			method:"GET",
			url :urlAllData,
			data:{"id":$scope.recherche },
			params:{"id": $scope.recherche} ,
			headers :{'Content-Type' :'application/json'} 
		}).success(function(data){
			console.log(data);
			$scope.data = data;			
		});		
	} // +"?id="+$scope.recherche 
	
	$scope.remove = function(tp) {
		console.log("---Methode delete----"+tp.id);
		$http({
			method:"DELETE",
			url :urlAllData+"?id="+tp.id ,
			data:"id="+tp.id ,
			headers :{'Content-Type' :'application/json'}
		}).success(function(data){
			$scope.message ="delete ok" ;
			$scope.viewAll() ; 
		});		
	}
	
	$scope.add = function() {
		$http({
			method:"POST",
			url :urlAllData ,
			data: {"nom" :$scope.nom },
			headers :{'Content-Type' :'application/json'}
		}).success(function(data){
			$scope.message ="add ok" ;
			$scope.viewAll() ; 
		});		
	}
	
	
});