package models

trait Module {
  type aiType <: AI
  def loadAI(ais: Iterable[aiType]): Unit
  def tick(): ModuleState.Value

  def preStart(): Unit
  def onStart(): Unit
  def onStop(): Unit
  def postStop(): Unit
}
