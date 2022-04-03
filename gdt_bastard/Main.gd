extends Node

var finishLine=10000
var gameRunning=true


# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	$InvisibleMap.visible=false
	$OccultBG.visible=false

func _process(delta):
	var view = get_viewport().get_visible_rect().size / 2
	var camera_pos = $SwipeCam.global_position

	var bounds_bw = 0#the camera bounds at the back
	var bounds_fw = camera_pos.x + view.x-10 #the camera bounds at the front

	if Input.is_action_pressed("spacebar"):
		$OccultBG.visible=true
		$InvisibleMap.visible=true
	else :
		$OccultBG.visible=false
		$InvisibleMap.visible=false
	#after the character is moved clamp its position to the end of the camera bounds
	$Player.global_position.x = clamp($Player.global_position.x, bounds_bw, bounds_fw)
	
	if $Player.global_position.x>=finishLine:
		win()
		

func playerExitScreen():
	if gameRunning:
		restart()
	return

func restart():
	get_tree().reload_current_scene()

func win():
	gameRunning=false
	get_tree().change_scene("res://WinScreen.tscn")
