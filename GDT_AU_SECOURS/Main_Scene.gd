extends Node2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"

var meteor_res=preload("res://Special_Envs/Meteor.tscn")
var player_res =preload("res://Node2D.tscn")
# Called when the node enters the scene tree for the first time.
func _ready():
	var meteor=meteor_res.instance()	
	var player = player_res.instance()
	add_child(meteor)
	add_child(player)
	pass # Replace with function body.


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
